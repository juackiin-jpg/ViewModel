package Screen

import android.R.attr.x
import android.R.attr.y
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.state.ui.theme.StateTheme

@Composable
fun InicioScreen (modifier: Modifier, numero:Int,miclick:()-> Unit){

    Column (modifier=modifier){
        var x by rememberSaveable() {mutableStateOf ("0") }
        var y by remember {mutableStateOf ("0") }
        var resultado by remember {mutableStateOf (0) }

        TextField (value = x, onValueChange = {textonuevo -> x=textonuevo} )
        Spacer(modifier = Modifier.padding(16.dp))

        TextField(value = y, onValueChange = {textonuevo -> y=textonuevo})
        Spacer(modifier = Modifier.padding(16.dp))
        Button(onClick = {resultado = (x.toInt())+ (y.toInt())}) { //La funcion de lo que quiero que haga el boton
            Text("Sumar")
        }
        Text(resultado.toString(), fontSize = 50.sp)


    }
   }


@Preview
@Composable
fun InicioScreen(){
    StateTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            var x by remember { mutableStateOf(0) }
            InicioScreen (modifier = Modifier.padding(innerPadding),x,{x+1})
        }
    }
}

