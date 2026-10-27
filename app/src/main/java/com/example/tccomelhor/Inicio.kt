package com.example.tccomelhor

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
fun Inicio(navController: NavController) {
    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = drawable.fundo_inicio),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillWidth
        )
        Image(
            painter = painterResource(id = drawable.logo_app),
            contentDescription = "Logo do aplicativo",
            modifier = Modifier
                .size(300.dp)
                .align(Alignment.TopCenter)
                .padding(top = 100.dp),
            contentScale = ContentScale.Fit
        )
        Image(
            painter = painterResource(id = drawable.raposa_inicio),
            contentDescription = "Raposa e uma menina",
            modifier = Modifier
                .size(450.dp)
                .align(alignment = Alignment.Center)
                .padding(top = 140.dp),
            contentScale = ContentScale.Fit
        )
        Image(
            painter = painterResource(id = drawable.balao),
            contentDescription = null,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .padding(bottom = 60.dp),
            contentScale = ContentScale.FillWidth
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 520.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        )
        {
            Box(
                modifier = Modifier
                    .width(200.dp)
                    .height(40.dp)
                    .clip(RoundedCornerShape(34.dp))
                    .background(color = Color(0xFF2684F3))
                    .clickable{
                        navController.navigate("login")
                    },
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Começar",
                    color = Color(0xFFFFFFFF),
                    fontSize = 20.sp,
                    modifier = Modifier,
                    fontWeight = FontWeight.Bold
                )
            }

            Text(
                text = "Criar sua conta",
                modifier = Modifier
                    .clickable{
                        navController.navigate("registro")
                    }
                    .padding(top = 10.dp),
                color = Color(0xFF2684F3),
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
            )
        }
    }
}