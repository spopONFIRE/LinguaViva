package com.example.tccomelhor

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
fun Registro(navController: NavController) {
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
                contentDescription = "Usúario",
                modifier = Modifier
                    .offset(x = (-68).dp)
                    .requiredSize(190.dp),
                contentScale = ContentScale.Fit
            )
            Text(
                text = "Nome Completo",
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
            painter = painterResource(id = drawable.email),
            contentDescription = "Email",
            modifier = Modifier
                .offset(x = (-38).dp)
                .requiredSize(130.dp),
            contentScale = ContentScale.Fit
        )
        Text(
            text = "Email",
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
                    .offset(y = 0.dp)
                    .padding(horizontal = 240.dp)
                    .requiredSize(140.dp),
                contentScale = ContentScale.Fit
            )
            Text(
                text = "Senha",
                color = Color(0xFF9ABBE1),
                fontWeight = FontWeight.Medium,
                modifier = Modifier
                    .padding(horizontal = 58.dp)
                    .offset(y = 15.dp)
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
                    .offset(y = 0.dp)
                    .padding(horizontal = 240.dp)
                    .requiredSize(140.dp),
                contentScale = ContentScale.Fit
            )
            Text(
                text = "Senha",
                color = Color(0xFF9ABBE1),
                fontWeight = FontWeight.Medium,
                modifier = Modifier
                    .padding(horizontal = 58.dp)
                    .offset(y = 15.dp)
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
                painter = painterResource(id = drawable.calendario),
                contentDescription = "calendario",
                modifier = Modifier
                    .offset(x = (-55).dp)
                    .requiredSize(170.dp),
                contentScale = ContentScale.Fit
            )
            Text(
                text = "Data de nascimento ",
                color = Color(0xFF3F6BC1),
                fontWeight = FontWeight.Medium,
                modifier = Modifier
                    .padding(horizontal = 58.dp)
                    .offset(y = 2.dp)
            )
            Text(
                text = "DD/MM/AAAA",
                color = Color(0xFF9ABBE1),
                fontWeight = FontWeight.Medium,
                modifier = Modifier
                    .padding(horizontal = 58.dp)
                    .offset(y = 24.dp)
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
    }
}