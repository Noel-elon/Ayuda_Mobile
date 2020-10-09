package com.example.ayudamobile.composables

import android.content.Context
import android.util.Log
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.shape.ZeroCornerSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.AndroidEmbeddingContext
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
import com.example.ayudamobile.AuthViewModel
import com.example.ayudamobile.models.UserModel
import com.example.ayudamobile.ui.bluish
import com.example.ayudamobile.ui.purple200
import com.example.ayudamobile.ui.red


@Preview
@Composable
fun SignUpPage() {

    form()
    //bg()


}


@Composable
fun form(vm: AuthViewModel? = null) {


    val mod = Modifier.padding(bottom = 8.dp)
    var firstName = remember { mutableStateOf(TextFieldValue("")) }
    val lastName = remember { mutableStateOf(TextFieldValue("")) }
    val email = remember { mutableStateOf(TextFieldValue("")) }
    val school = remember { mutableStateOf(TextFieldValue("")) }
    val password = remember { mutableStateOf(TextFieldValue("")) }

    val country = remember { mutableStateOf(TextFieldValue("")) }
    val field = remember { mutableStateOf(TextFieldValue("")) }
    val userModel = UserModel(
        firstName = firstName.value.text,
        lastName = lastName.value.text,
        email = email.value.text,
        school = school.value.text,
        country = country.value.text,
        field = field.value.text,
        password = password.value.text
    )

    Surface(
        color = bluish,
        modifier = Modifier.fillMaxSize(),

        ) {


        ScrollableColumn(
            modifier = mod,
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Hey There!",
                modifier = Modifier.padding(top = 8.dp),
                style = TextStyle(
                    fontSize = 25.sp,
                    color = Color.White,
                    fontWeight = FontWeight.ExtraBold,
                    fontFamily = FontFamily.SansSerif
                )
            )
            Text(
                text = "Sign up",
                modifier = Modifier.padding(top = 8.dp, bottom = 8.dp),
                style = TextStyle(
                    fontSize = 22.sp,
                    color = Color.White,
                    fontWeight = FontWeight.ExtraBold,
                    fontFamily = FontFamily.SansSerif
                )
            )

            OutlinedTextField(
                value = firstName.value,
                onValueChange = {
                    firstName.value = it
                }, activeColor = red, inactiveColor = Color.White, modifier = mod,
                label = { Text(text = "First Name") },
                leadingIcon = {
                    Icon(
                        Icons.Filled.Person, tint = Color.White
                    )
                })

            OutlinedTextField(
                value = lastName.value,
                onValueChange = {
                    lastName.value = it
                }, activeColor = red, inactiveColor = Color.White, modifier = mod,
                label = { Text(text = "Last Name") },
                leadingIcon = {
                    Icon(
                        Icons.Filled.Person, tint = Color.White
                    )
                })

            OutlinedTextField(
                value = email.value,
                onValueChange = {
                    email.value = it
                },
                activeColor = red,
                inactiveColor = Color.White,
                modifier = mod,
                label = { Text(text = "Email") },
                leadingIcon = {
                    Icon(
                        Icons.Filled.Email, tint = Color.White
                    )
                },
                keyboardType = KeyboardType.Email
            )

            OutlinedTextField(
                value = school.value,
                onValueChange = {
                    school.value = it
                },
                activeColor = red,
                inactiveColor = Color.White,
                modifier = mod,
                label = { Text(text = "School") },
                leadingIcon = {
                    Icon(
                        Icons.Filled.Home, tint = Color.White
                    )
                })

            OutlinedTextField(
                value = country.value,
                onValueChange = {
                    country.value = it
                },
                activeColor = red,
                inactiveColor = Color.White,
                modifier = mod,
                label = { Text(text = "Country") },
                leadingIcon = {
                    Icon(
                        Icons.Filled.LocationOn, tint = Color.White
                    )
                })

            OutlinedTextField(
                value = field.value,
                onValueChange = {
                    field.value = it
                },
                activeColor = red,
                inactiveColor = Color.White,
                modifier = mod,
                label = { Text(text = "Field") },
                leadingIcon = {
                    Icon(
                        Icons.Filled.Info, tint = Color.White
                    )
                })

            OutlinedTextField(
                value = password.value,
                onValueChange = {
                    password.value = it
                },
                activeColor = red,
                inactiveColor = Color.White,
                modifier = mod,
                label = { Text(text = "Password") },
                leadingIcon = {
                    Icon(
                        Icons.Filled.Lock, tint = Color.White
                    )
                },
                keyboardType = KeyboardType.Password
            )

            Button(
                onClick = {
                    Log.d("Button: ", "$userModel")
                    vm?.registerUser(userModel = userModel)

                },
                backgroundColor = red,
                shape = RoundedCornerShape(8.dp),
                contentColor = Color.White,
                modifier = Modifier.width(300.dp).padding(8.dp)
            ) {
                Text(text = "Sign up")
            }

            Divider(modifier = Modifier.padding(16.dp), color = red)

            Text(
                text = "or",
                fontSize = 12.sp,
                color = red,
                modifier = Modifier.padding(4.dp)
            )

            Text(
                text = "Sign in",
                fontSize = 16.sp,
                modifier = Modifier.padding(8.dp).clickable(onClick = {}),
                color = Color.White
            )


        }

    }

}