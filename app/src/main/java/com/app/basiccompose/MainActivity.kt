package com.app.basiccompose


import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items

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
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.Dp
import coil.compose.ImagePainter
import coil.compose.rememberImagePainter
import coil.transform.BlurTransformation
import coil.transform.CircleCropTransformation
import coil.transform.GrayscaleTransformation
import coil.transform.RoundedCornersTransformation
import com.app.basiccompose.ui.theme.Shapes

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalFoundationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BasicComposeTheme {
                val sections = listOf("A","B","C","D","E","G","H")
                val personRespositery = PersonRespositery()
                val getAllData = personRespositery.getAllItem()
                LazyColumn(contentPadding = PaddingValues(all = 12.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)){

                    sections.forEach {section ->
                        stickyHeader { 
                            Text(modifier = Modifier
                                .fillMaxWidth()
                                .background(Color.LightGray)
                                .padding(12.dp),
                                text = "Section $sections")
                        }
                        items(10){
                            Text(text = "Item $it from the section $section")
                        }

                    }
//                    items(items = getAllData){ person ->
//                        CustomItem(person = person)
//
//                    }
                }
                // A surface container using the 'background' color from the theme
//                Column(
//                    modifier = Modifier.fillMaxSize(),
//                    verticalArrangement = Arrangement.Center,
//                    horizontalAlignment = Alignment.CenterHorizontally
                 //   color = MaterialTheme.colors.background
       //         ) {
                //   Greeting()
                //    CustomText4()
//                    ExpandableCard(title = "My Title", description ="fggg  sgjlgj kj  sjglsjgl jslgjjjl sgjsgjgkl" +
//                            "fggg  sgjlgj kj  sjglsjgl jslgjjjl sgjsgjgkl" +
//                            "fggg  sgjlgj kj  sjglsjgl jslgjjjl sgjsgjgkl" +
//                            "fggg  sgjlgj kj  sjglsjgl jslgjjjl sgjsgjgkl" )
                   // TextFieddemo()
//                    GoogleButton(
//                        text = "Sign Up with Google",
//                        loadingText = "Creating Account....",
//                        onClick = {
//                            Log.d("google button","Clicked")
//                        }
//                    )
                 //   CoilImage()
                 //   PasswordTextField()
          //  }
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

            OutlinedTextField(value = text, onValueChange = { newText ->
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
               keyboardActions = KeyboardActions(
                   onSearch = {
                       Toast.makeText(this@MainActivity,"Clicked",Toast.LENGTH_SHORT).show()
                   }

               )
            )
        }


    }

    @Composable
    fun CoilImage(){
        Box( modifier = Modifier
            .height(150.dp)
            .width(150.dp),
        contentAlignment = Alignment.Center) {
            val painter = rememberImagePainter(
                data = "https://avatars.githubusercontent.com/u/14994036?v=4",
                    builder = {
                        placeholder(R.drawable.ic_google_logo)
                        error(R.drawable.ic_google_logo)
                        crossfade(1000)
                        transformations(
                            GrayscaleTransformation(),
           //                 CircleCropTransformation(),
                            BlurTransformation(LocalContext.current),
                            RoundedCornersTransformation(50f)
                        )

            })
            val painterState = painter.state
            Image(painter = painter, contentDescription ="Logo Image" )
//            if(painterState is ImagePainter.State.Loading){
//                CircularProgressIndicator()
//            }

        }


    }

    @Composable
    fun PasswordTextField(){
        Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {
            var password by rememberSaveable { mutableStateOf("") }
            var passwordVisibility by remember { mutableStateOf(false)}

            val icon = if (passwordVisibility)
                painterResource(id = R.drawable.ic_baseline_visibility_24)
            else
                painterResource(id = R.drawable.ic_baseline_visibility_off_24)

            OutlinedTextField(value = password, onValueChange = {
                password = it
            },
                placeholder = { Text(text = "Password")},
                label = { Text(text = "Password")},
                trailingIcon = {
                    IconButton(onClick = { passwordVisibility = !passwordVisibility }) {
                        Icon(painter = icon, contentDescription ="Visibility" )
                        
                    }
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                visualTransformation = if (passwordVisibility) VisualTransformation.None
            else PasswordVisualTransformation()
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
            //
        // TextFieddemo()
          //  CoilImage()
            PasswordTextField()
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