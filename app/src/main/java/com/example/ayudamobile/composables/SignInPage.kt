package com.example.ayudamobile.composables

import androidx.activity.OnBackPressedDispatcher
import androidx.compose.animation.Crossfade
import androidx.compose.foundation.Icon
import androidx.compose.foundation.ScrollableColumn
import androidx.compose.foundation.Text
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.shape.ZeroCornerSize
import androidx.compose.material.Button
import androidx.compose.material.Divider
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Providers
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.savedinstancestate.rememberSavedInstanceState
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
import com.example.ayudamobile.*
import com.example.ayudamobile.ui.bluish
import com.example.ayudamobile.ui.purple200
import com.example.ayudamobile.ui.red

@Preview(showBackground = true)
@Composable
fun SignInPage() {
    Surface(color = red, modifier = Modifier.fillMaxSize()) {
       // mainScreen()
    }


}

@Composable
fun navMain(viewModel: AuthViewModel, backDispatcher: OnBackPressedDispatcher) {
    val navigator: Navigator<Destination> = rememberSavedInstanceState(
        saver = Navigator.saver(backDispatcher)
    ) {
        Navigator(Destination.SignIn, backDispatcher)
    }
    val actions = remember(navigator) { Actions(navigator) }

    Providers(BackDispatcherAmbient provides backDispatcher) {
        ProvideDisplayInsets {
            Crossfade(navigator.current) { destination ->
                when (destination) {
                    is Destination.SignIn -> {
                        mainScreen(viewModel = viewModel, onNavigateClick = actions.signUp)
                    }
                    is Destination.Feed -> {
                        topics()
                    }
                    is Destination.SignUp -> {
                        form(viewModel)
                    }
                }
            }
        }
    }
}


@Composable
fun mainScreen(viewModel: AuthViewModel? = null, onNavigateClick: () -> Unit) {
    val mod = Modifier.padding(bottom = 8.dp)
    val email = remember { mutableStateOf(TextFieldValue("")) }
    val password = remember { mutableStateOf(TextFieldValue("")) }



    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center, modifier = Modifier.fillMaxSize()
    ) {
        Text(
            text = "Welcome Back!",
            modifier = Modifier.padding(top = 8.dp, start = 16.dp),
            style = TextStyle(
                fontSize = 30.sp,
                color = Color.White,
                fontWeight = FontWeight.ExtraBold,
                fontFamily = appFontFamily
            )
        )
        Text(
            text = "Sign in",
            modifier = Modifier.padding(start = 16.dp, top = 4.dp),
            style = TextStyle(
                fontSize = 22.sp,
                color = Color.White,
                fontWeight = FontWeight.ExtraBold,
                fontFamily = appFontFamily
            )
        )

        OutlinedTextField(
            value = email.value,
            onValueChange = {
                email.value = it
            },
            activeColor = bluish,
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
            value = password.value,
            onValueChange = {
                password.value = it
            },
            activeColor = bluish,
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
            onClick = {},
            backgroundColor = bluish,
            shape = RoundedCornerShape(8.dp),
            contentColor = Color.White,
            modifier = Modifier.width(300.dp).padding(8.dp)
        ) {
            Text(text = "Sign In")
        }

        Divider(modifier = Modifier.padding(start = 32.dp, end = 32.dp), color = bluish)

        Text(
            text = "or",
            fontSize = 16.sp,
            color = bluish,
            modifier = Modifier.padding(4.dp)
        )

        Text(
            text = "Sign up",
            fontSize = 16.sp,
            modifier = Modifier.padding(8.dp).clickable(onClick = { onNavigateClick }),
            color = Color.White
        )


    }
}