package com.example.tccomelhor

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import kotlinx.coroutines.launch

@Composable
fun CampoRegistro(
    valor: String,
    aoMudar: (String) -> Unit,
    dica: String,
    icone: Int,
    iconeX: Int,
    iconeTam: Int,
    ocultar: Boolean = false,
    teclado: KeyboardType = KeyboardType.Text
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .offset(y = (-50).dp)
            .padding(horizontal = 30.dp)
            .height(50.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(Color(0xFFF8FBFE))
            .border(2.dp, Color(0xFFD9E8F7), RoundedCornerShape(16.dp))
    ) {
        Image(
            painter = painterResource(id = icone),
            contentDescription = dica,
            modifier = Modifier
                .offset(x = iconeX.dp)
                .requiredSize(iconeTam.dp),
            contentScale = ContentScale.Fit
        )
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 58.dp),
            contentAlignment = Alignment.CenterStart
        ) {
            if (valor.isEmpty()) {
                Text(dica, color = Color(0xFF9ABBE1), fontWeight = FontWeight.Medium)
            }
            BasicTextField(
                value = valor,
                onValueChange = aoMudar,
                singleLine = true,
                textStyle = TextStyle(color = Color(0xFF2B3A55), fontSize = 16.sp),
                visualTransformation = if (ocultar) PasswordVisualTransformation()
                else VisualTransformation.None,
                keyboardOptions = KeyboardOptions(keyboardType = teclado),
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@Composable
fun Registro(navController: NavController) {
    var nome by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var senha by remember { mutableStateOf("") }
    var confirmar by remember { mutableStateOf("") }
    var erro by remember { mutableStateOf<String?>(null) }
    var carregando by remember { mutableStateOf(false) }
    val scope = rememberCoroutineScope()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF4F7FD))
            .verticalScroll(rememberScrollState())
            .padding(horizontal = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo_app),
            contentDescription = "Logo do aplicativo",
            modifier = Modifier.size(300.dp),
            contentScale = ContentScale.Fit
        )
        Text(
            text = "Vamos criar sua conta!",
            modifier = Modifier.offset(y = (-80).dp),
            color = Color(0xFF2684F3),
            fontSize = 20.sp,
            fontWeight = FontWeight.Medium
        )
        Text(
            text = "É rápido e fácil. Assim voce já pode",
            modifier = Modifier.offset(y = (-76).dp),
            color = Color(0xFF9ABBE1),
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium
        )
        Text(
            text = "começar a aprender",
            modifier = Modifier.offset(y = (-74).dp),
            color = Color(0xFF9ABBE1),
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium
        )

        CampoRegistro(nome, { nome = it }, "Nome Completo", R.drawable.usuario, -68, 190)
        Spacer(modifier = Modifier.height(16.dp))
        CampoRegistro(email, { email = it }, "Email", R.drawable.email, -38, 130,
            teclado = KeyboardType.Email)
        Spacer(modifier = Modifier.height(16.dp))
        CampoRegistro(senha, { senha = it }, "Senha", R.drawable.senha, -55, 170,
            ocultar = true)
        Spacer(modifier = Modifier.height(16.dp))
        CampoRegistro(confirmar, { confirmar = it }, "Confirmar senha", R.drawable.senha, -55, 170,
            ocultar = true)
        Spacer(modifier = Modifier.height(10.dp))

        erro?.let {
            Text(it, color = Color.Red, fontSize = 14.sp)
            Spacer(modifier = Modifier.height(8.dp))
        }

        Box(
            modifier = Modifier
                .width(300.dp)
                .height(60.dp)
                .clip(RoundedCornerShape(26.dp))
                .background(if (carregando) Color(0xFF9ABBE1) else Color(0xFF2684F3))
                .clickable(enabled = !carregando) {
                    erro = null
                    when {
                        nome.isBlank() || email.isBlank() || senha.isBlank() ->
                            erro = "Preencha todos os campos"
                        !android.util.Patterns.EMAIL_ADDRESS.matcher(email.trim()).matches() ->
                            erro = "Email inválido"
                        senha.length < 6 ->
                            erro = "A senha precisa ter pelo menos 6 caracteres"
                        senha != confirmar ->
                            erro = "As senhas não conferem"
                        else -> scope.launch {
                            carregando = true
                            try {
                                val resp = ApiClient.api.registrar(
                                    RegistroRequest(nome.trim(), email.trim(), senha)
                                )
                                if (resp.isSuccessful) {
                                    navController.navigate("login") // troque pelo nome da sua rota
                                } else {
                                    erro = if (resp.code() == 409) "Email já cadastrado"
                                    else "Erro ao cadastrar"
                                }
                            } catch (e: Exception) {
                                erro = "Sem conexão com o servidor"
                            }
                            carregando = false
                        }
                    }
                },
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = if (carregando) "Aguarde..." else "Começar",
                color = Color.White,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}