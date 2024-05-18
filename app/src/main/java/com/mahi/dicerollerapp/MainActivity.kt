package com.mahi.dicerollerapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mahi.dicerollerapp.ui.theme.DiceRollerAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DiceRollerAppTheme {
                // A surface container using the 'background' color from the theme
                Surface()
                {
                    DiceAndRollButton(modifier = Modifier
                        .fillMaxSize()
                        .wrapContentSize(Alignment.Center)
                    )
                }
            }
        }
    }
}
@Composable
fun DiceAndRollButton(modifier: Modifier =  Modifier){
    var dice by remember {mutableStateOf(1) }
    val valueDice= when(dice){
        1->R.drawable.dice_1
        2->R.drawable.dice_2
        3->R.drawable.dice_3
        4->R.drawable.dice_4
        5->R.drawable.dice_5
        else->
            R.drawable.dice_6
    }
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.pink)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
        ) {
        Text(
            text = stringResource(R.string.dice_roller),
            fontWeight = Bold,
            fontSize = 32.sp

                    )
        Image(
            painter = painterResource(id = valueDice),
            contentDescription = dice.toString(),
            modifier = Modifier.background(colorResource(id = R.color.pink))
        )
        Spacer(modifier = Modifier
            .height(16.dp)
            .background(colorResource(id = R.color.pink)))
        Button(onClick = { dice = (1..6).random() }) {
            Text(
                text = stringResource(id = R.string.roll))
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DiceRoller() {
    DiceRollerAppTheme {
        DiceAndRollButton(modifier = Modifier
            .fillMaxSize()
            .background(
                colorResource(id = R.color.pink)

            )
            )

    }
}