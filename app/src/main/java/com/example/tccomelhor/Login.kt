package com.example.tccomelhor

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.tccomelhor.R.drawable

@Composable
fun Login(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF4F7FD))
            .padding(horizontal = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = drawable.logo_app),
            contentDescription = "Logo do aplicativo",
            modifier = Modifier
                .size(300.dp),
            contentScale = ContentScale.Fit
        )
        Text (
            text = "Que bom te ver de novo!",
            modifier = Modifier.offset(y = (-80).dp),
            color = Color(0xFF2684F3),
            fontSize = 20.sp,
            fontWeight = FontWeight.Medium
        )
        Text(
            text = "Faça login para continuar a jornada.",
            color = Color(0xFF9ABBE1),
            modifier = Modifier.offset(y = (-76).dp),
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .offset(y = (-50).dp)
                .padding(horizontal = 30.dp)
                .height(50.dp)
                .clip(RoundedCornerShape(16.dp))
                .background(Color(0xFFF4F7FD))
                .border(2.dp, Color(0xFFD9E8F7),RoundedCornerShape(16.dp))
        ){
            Image(
                painter = painterResource(id = drawable.usuario),
                contentDescription = "Email",
                modifier = Modifier
                    .offset(x = (-68).dp)
                    .requiredSize(190.dp),
                contentScale = ContentScale.Fit
            )
            Text(
                text = "Email do usúario",
                color = Color(0xFF9ABBE1),
                fontWeight = FontWeight.Medium,
                modifier = Modifier
                    .padding(top = 15.dp)
                    .padding(horizontal = 58.dp)
            )
        }
        Spacer(modifier = Modifier.height(16.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .offset(y = (-50).dp)
                .padding(horizontal = 30.dp)
                .height(50.dp)
                .clip(RoundedCornerShape(16.dp))
                .background(Color(0xFFF8FBFE))
                .border(2.dp, Color(0xFFD9E8F7),RoundedCornerShape(16.dp))
        ){
            Image(
                painter = painterResource(id = drawable.senha),
                contentDescription = "senha",
                modifier = Modifier
                    .offset(x = (-55).dp)
                    .requiredSize(170.dp),
                contentScale = ContentScale.Fit
            )
            Image(
                painter = painterResource(id = drawable.senha_olho),
                contentDescription = "Olho senha",
                modifier = Modifier
                    .padding(horizontal = 240.dp)
                    .requiredSize(140.dp),
                contentScale = ContentScale.Fit
            )
            Text(
                text = "Senha",
                color = Color(0xFF9ABBE1),
                fontWeight = FontWeight.Medium,
                modifier = Modifier
                    .padding(top = 15.dp)
                    .padding(horizontal = 58.dp)
            )
        }

        Spacer(modifier = Modifier.height(10.dp))

        Box(
            modifier = Modifier
                .width(300.dp)
                .height(60.dp)
                .clip(shape = RoundedCornerShape(26.dp))
                .background(Color(0xFF2684F3)),
            contentAlignment = Alignment.Center
        ){
            Text(
                text = "Começar",
                color = Color(0xFFFFFFFF),
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Box(
                modifier = Modifier
                    .width(100.dp)
                    .height(2.dp)
                    .background(Color(0xFFD2E4F8))
            )
            Text(
                text = "ou",
                color = Color(0xFF3F6BC1),
                fontWeight = FontWeight.Medium,
                fontSize = 14.sp,
                        modifier = Modifier
                            .padding(horizontal = 15.dp)
            )
            Box(
                modifier = Modifier
                    .width(100.dp)
                    .height(2.dp)
                    .background(Color(0xFFD2E4F8))
                    .padding(horizontal = 150.dp)
            )
        }

        Spacer(modifier = Modifier.height(120.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Não tem uma conta?",
                color = Color(0xFF3F6BC1),
                fontWeight = FontWeight.Medium,
                fontSize = 14.sp
            )
            Text(
                text = "Cadastre-se",
                color = Color(0xFF398AF5),
                fontWeight = FontWeight.Medium,
                fontSize = 14.sp,
                modifier = Modifier.clickable{
                        navController.navigate("registro")
                }
            )
        }
    }
}