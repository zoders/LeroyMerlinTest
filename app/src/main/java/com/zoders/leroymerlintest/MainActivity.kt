package com.zoders.leroymerlintest

import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.widget.ListView
import android.widget.SimpleCursorAdapter
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner
import androidx.lifecycle.viewmodel.compose.viewModel
import com.zoders.leroymerlintest.data.db.Product
import com.zoders.leroymerlintest.data.db.ProductDatabase
import com.zoders.leroymerlintest.data.db.ProductRepository
//import com.zoders.leroymerlintest.data.db.ProductsFromDb
import com.zoders.leroymerlintest.ui.LeroyMerlinTestApp
import com.zoders.leroymerlintest.ui.MainPageViewModel
import com.zoders.leroymerlintest.ui.MainPageViewModelFactory
import com.zoders.leroymerlintest.ui.theme.LeroyMerlinTestTheme
import kotlinx.coroutines.delay


class MainActivity : ComponentActivity() {

    private val viewModel: MainPageViewModel by viewModels {
        MainPageViewModelFactory((application as ProductApplication).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.allProducts.observe(this) { products ->
            products.let {
                setContent {
                    LeroyMerlinTestTheme {
                        Surface(
                            modifier = Modifier.fillMaxSize(),
                            color = MaterialTheme.colors.background
                        ) {
                            LeroyMerlinTestApp(viewModel, it)
                        }
                    }
                }
            }
        }


    }
}

@Preview(showBackground = true)
@Composable
fun LeroyMerlinTestAppPreviewDefault() {
    //LeroyMerlinTestApp(viewModel = MainPageViewModel())
}

@Preview(showBackground = true)
@Composable
fun PreviewAll() {
    /*LeroyMerlinTestTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            LeroyMerlinTestApp(MainPageViewModel())
        }
    }*/
}
