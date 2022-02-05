package com.app.basiccompose


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.selection.DisableSelection
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.ParagraphStyle
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.BaselineShift
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.basiccompose.ui.theme.BasicComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BasicComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(

                    color = MaterialTheme.colors.background
                ) {
                //   Greeting()
                    CustomText4()
            }
        }
    }
}
    @Composable
    fun CustomText(){
        Text(text = stringResource(id = R.string.app_name),
            modifier = Modifier
                .background(MaterialTheme.colors.primary)
                .width(200.dp)
                .padding(16.dp),
            color = Color.White, fontSize = MaterialTheme.typography.h6.fontSize,
            fontStyle = FontStyle.Italic,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.End
        )
    }

    @Composable
    fun CustomText2(){

        Text(buildAnnotatedString {
            withStyle(style = ParagraphStyle(textAlign = TextAlign.Center)){
                withStyle(style = SpanStyle(
                    color = MaterialTheme.colors.primary,
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold
                )){
                    append("A")
                }

                append("B")
                append("C")
                append("D")
            }

        }, modifier = Modifier.width(200.dp)
        )
    }

    @Composable
    fun CustomText3(){
        Text(text = "Hello World".repeat(20), maxLines = 2, overflow = TextOverflow.Ellipsis)

    }

@Composable
fun Greeting() {
    Column(modifier = Modifier.fillMaxSize()) {
     CustomText3()

    }

}

    @Composable
    fun CustomText4(){



            SelectionContainer() {
                Column() {
                Text(text = "Hello World")
                DisableSelection {
                    Text(text = "Hello World")
                }
                Text(text = "Hello World")
            }


        }
    }

    @Composable
    fun SuperScriptText(normalText : String,
                        superText : String,
                        normalFontSize : TextUnit = MaterialTheme.typography.subtitle1.fontSize,
                        superFontSize : TextUnit = MaterialTheme.typography.overline.fontSize,
                        superFontWeight : FontWeight = FontWeight.Normal
    ){
        Text(buildAnnotatedString {
            withStyle(style = SpanStyle(
                fontSize = normalFontSize
            )
            ){
                append(normalText)
            }
            withStyle(style = SpanStyle(
                fontSize = superFontSize,
                fontWeight = superFontWeight,
                baselineShift = BaselineShift.Superscript
            )
            ){
                append(superText)
            }
        })
    }



@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BasicComposeTheme {
        Column(modifier = Modifier.fillMaxSize()) {
            SuperScriptText(normalText = "Hello", superText = "World",
            superFontWeight = FontWeight.Light
            )
        }

    }
}

    }