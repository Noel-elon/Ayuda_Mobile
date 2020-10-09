package com.example.ayudamobile.composables

import android.content.Context
import android.util.Log
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
import com.example.ayudamobile.ui.purple200


@Preview
@Composable
fun SignUpPage() {

    form()
    //bg()


}


@Composable
fun bg() {


    Surface(color = purple200) {
        Column(
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(bottom = 8.dp)
        ) {


        }


    }
}

@Composable
fun form(vm: AuthViewModel? = null) {

    val signInText = annotatedString {
        append("Already have an account?")
        withStyle(SpanStyle(Color.Blue)) {
            append("Sign in!")
        }
    }
    val mod = Modifier.padding(bottom = 8.dp)
    val firstName = remember { mutableStateOf(TextFieldValue("")) }
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
                text = "Create your account",
                modifier = Modifier.padding(16.dp),
                style = TextStyle(
                    fontSize = 22.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.ExtraBold,
                    fontFamily = FontFamily.SansSerif
                )
            )

            OutlinedTextField(
                value = firstName.value,
                onValueChange = {
                    firstName.value = it
                }, modifier = mod,
                label = { Text(text = "First Name") },
                leadingIcon = {
                    Icon(
                        Icons.Filled.Person
                    )
                })

            OutlinedTextField(
                value = lastName.value,
                onValueChange = {
                    lastName.value = it
                }, modifier = mod,
                label = { Text(text = "Last Name") },
                leadingIcon = {
                    Icon(
                        Icons.Filled.Person
                    )
                })

            OutlinedTextField(value = email.value, onValueChange = {
                email.value = it
            }, modifier = mod, label = { Text(text = "Email") }, leadingIcon = {
                Icon(
                    Icons.Filled.Email
                )
            }, keyboardType = KeyboardType.Email)

            OutlinedTextField(value = school.value, onValueChange = {
                school.value = it
            }, mod, label = { Text(text = "School") }, leadingIcon = {
                Icon(
                    Icons.Filled.Home
                )
            })

            OutlinedTextField(value = country.value, onValueChange = {
                country.value = it
            }, mod, label = { Text(text = "Country") }, leadingIcon = {
                Icon(
                    Icons.Filled.LocationOn
                )
            })

            OutlinedTextField(value = field.value, onValueChange = {
                field.value = it
            }, mod, label = { Text(text = "Field") }, leadingIcon = {
                Icon(
                    Icons.Filled.Info
                )
            })

            OutlinedTextField(value = password.value, onValueChange = {
                password.value = it
            }, mod, label = { Text(text = "Password") }, leadingIcon = {
                Icon(
                    Icons.Filled.Lock
                )
            }, keyboardType = KeyboardType.Password)


            Button(
                onClick = {
                    Log.d("Button: ", "$userModel")
                    //vm?.registerUser(userModel = userModel)

                },
                backgroundColor = purple200,
                shape = RoundedCornerShape(4.dp),
                contentColor = Color.White,
                modifier = Modifier.width(300.dp).padding(8.dp)
            ) {
                Text(text = "Sign up")
            }

            Spacer(modifier = Modifier.padding(vertical = 4.dp))

            Text(
                text = signInText,
                color = purple200,
                modifier = Modifier.padding(8.dp)
            )


        }

    }

}