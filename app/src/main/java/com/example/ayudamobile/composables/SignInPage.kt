package com.example.ayudamobile.composables

import androidx.compose.foundation.Icon
import androidx.compose.foundation.ScrollableColumn
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.shape.ZeroCornerSize
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.annotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.ui.tooling.preview.Preview
import com.example.ayudamobile.ui.purple200

@Preview(showBackground = true)
@Composable
fun SignInPage() {
    mainScreen()

}


@Composable
fun mainScreen() {

    val signUpText = annotatedString {
        append("Don't have an account? ")
        withStyle(SpanStyle(Color.Blue)) {
            append("Sign up!")
        }
    }
    val mod = Modifier.padding(bottom = 8.dp)
    val email = remember { mutableStateOf(TextFieldValue("")) }
    val password = remember { mutableStateOf(TextFieldValue("")) }


    Surface(
        color = Color.White,
        modifier = Modifier.fillMaxSize(),
        shape = RoundedCornerShape(40.dp).copy(
            topLeft = ZeroCornerSize,
            topRight = ZeroCornerSize
        )
    ) {
        ScrollableColumn(
            modifier = mod,
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Sign in to your account",
                modifier = Modifier.padding(16.dp),
                style = TextStyle(
                    fontSize = 22.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.ExtraBold,
                    fontFamily = FontFamily.SansSerif
                )
            )



            OutlinedTextField(value = email.value, onValueChange = {
                email.value = it
            }, modifier = mod, label = { Text(text = "Email") }, leadingIcon = {
                Icon(
                    Icons.Filled.Email
                )
            }, keyboardType = KeyboardType.Email)




            OutlinedTextField(value = password.value, onValueChange = {
                password.value = it
            }, mod, label = { Text(text = "Password") }, leadingIcon = {
                Icon(
                    Icons.Filled.Lock
                )
            }, keyboardType = KeyboardType.Password)


            Button(
                onClick = {},
                backgroundColor = purple200,
                shape = RoundedCornerShape(4.dp),
                contentColor = Color.White,
                modifier = Modifier.width(300.dp).padding(8.dp)
            ) {
                Text(text = "Sign In")
            }

            Spacer(modifier = Modifier.padding(vertical = 4.dp))

            Text(
                text = signUpText,
                color = purple200,
                modifier = Modifier.padding(8.dp)
            )


        }

    }
}