package com.example.jetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.jetpackcompose.repository.PersonRepository
import com.example.jetpackcompose.ui.theme.JetpackComposeTheme

class MainActivity : ComponentActivity() {

    @OptIn(ExperimentalFoundationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeTheme {
                /*val personRepository = PersonRepository()
                val getAllData = personRepository.getAllData()

                LazyColumn(
                    contentPadding = PaddingValues(all = 20.dp),
                    verticalArrangement = Arrangement.spacedBy(15.dp)
                ){
                    items(items = getAllData){ person ->
                        CustomItem(person = person)
                    }

                }*/

                val sections = listOf("A","B","C","G","E")

                LazyColumn(
                    contentPadding = PaddingValues(all = 20.dp),
                    verticalArrangement = Arrangement.spacedBy(15.dp)
                ){
                    sections.forEach { section ->
                        stickyHeader {
                            Text(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .background(Color.LightGray)
                                    .padding(12.dp),
                                text = "Section $section"
                            )
                        }
                        items(10){
                            Text(
                                modifier = Modifier.padding(12.dp),
                                text = "item $it from the sction $section"
                            )
                        }
                    }
                }

            }
        }
    }
}