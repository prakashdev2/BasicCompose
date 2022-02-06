package com.app.basiccompose


import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*

import androidx.compose.foundation.shape.CornerBasedShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.selection.DisableSelection
import androidx.compose.foundation.text.selection.SelectionContainer

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Email
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
import androidx.compose.runtime.*
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.Dp
import com.app.basiccompose.ui.theme.Shapes

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
                //    CustomText4()
//                    ExpandableCard(title = "My Title", description ="fggg  sgjlgj kj  sjglsjgl jslgjjjl sgjsgjgkl" +
//                            "fggg  sgjlgj kj  sjglsjgl jslgjjjl sgjsgjgkl" +
//                            "fggg  sgjlgj kj  sjglsjgl jslgjjjl sgjsgjgkl" +
//                            "fggg  sgjlgj kj  sjglsjgl jslgjjjl sgjsgjgkl" )
                    TextFieddemo()
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

    @OptIn(ExperimentalMaterialApi::class)
    @Composable
    fun ExpandableCard(title : String,
                       titleFontSize : TextUnit = MaterialTheme.typography.h6.fontSize,
                       textFontWeight : FontWeight = FontWeight.Bold,
                        description : String,
                        descriptionFontSize : TextUnit = MaterialTheme.typography.subtitle1.fontSize,
                       descriptionFontWeight :FontWeight = FontWeight.Normal,
                       descriptionMaxLines : Int = 4,
                       shape : CornerBasedShape = Shapes.medium,
                       padding : Dp = 12.dp
    ){
        var expandableState by remember { mutableStateOf(false)}
        val rotateState by animateFloatAsState(
            targetValue = if (expandableState) 180f else 0f)

        Card(modifier = Modifier
            .fillMaxWidth()
            .animateContentSize(
                animationSpec = tween(
                    durationMillis = 300,
                    easing = LinearOutSlowInEasing
                )
            ),
        shape = shape,
        onClick = {
            expandableState = !expandableState
        }) {
            
            Column(modifier = Modifier
                .fillMaxWidth()
                .padding(padding)
            ) {
                
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(modifier = Modifier.weight(3f),
                        text = "My Title",
                    fontSize = titleFontSize,
                    fontWeight = textFontWeight,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis)
                    
                    IconButton(
                        modifier = Modifier
                            .alpha(ContentAlpha.medium)
                            .weight(1f)
                            .rotate(rotateState),
                        onClick = { expandableState =!expandableState }) {

                        Icon(
                            imageVector = Icons.Default.ArrowDropDown,
                            contentDescription = "Drop Down Arrow"
                        )
                        
                    }

                    
                }
                
                if (expandableState){
                    Text(text = description ,
                    fontSize = descriptionFontSize,
                    fontWeight = descriptionFontWeight,
                        maxLines = descriptionMaxLines,
                        overflow = TextOverflow.Ellipsis
                    )
                }
                
                

            }
      
        }

    }

    @Composable
    fun TextFieddemo(){
        Column(modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        ){
            var text by remember { mutableStateOf("Type here...") }

            TextField(value = text, onValueChange = { newText ->
                text = newText
            },

                label = {
                    Text(text = "Title")
                },
                leadingIcon = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(imageVector = Icons.Filled.Email, contentDescription = "Email")

                    }
                },
                trailingIcon = {
                    IconButton(onClick = { Toast.makeText(this@MainActivity,"Clicked",Toast.LENGTH_SHORT).show() }) {
                        Icon(imageVector = Icons.Filled.Check, contentDescription = "Email")

                    }
                },
               keyboardOptions = KeyboardOptions(
                   keyboardType = KeyboardType.Email,
                   imeAction = ImeAction.Go
               )
            )
        }


    }

@ExperimentalMaterialApi
    @Composable
    @Preview
    fun ExpandableCardPreview(){
        BasicComposeTheme {
//            ExpandableCard(title = "My Title", description ="fggg  sgjlgj kj  sjglsjgl jslgjjjl sgjsgjgkl" +
//                    "fggg  sgjlgj kj  sjglsjgl jslgjjjl sgjsgjgkl" +
//                    "fggg  sgjlgj kj  sjglsjgl jslgjjjl sgjsgjgkl" +
//                    "fggg  sgjlgj kj  sjglsjgl jslgjjjl sgjsgjgkl" )
            TextFieddemo()
        }

    }



//@Preview(showBackground = true)
//@Composable
//fun DefaultPreview() {
//    BasicComposeTheme {
//        Column(modifier = Modifier.fillMaxSize()) {
//            SuperScriptText(normalText = "Hello", superText = "World",
//            superFontWeight = FontWeight.Light
//            )
//        }
//
//    }
//}

    }