package com.example.jetpackcompose

const val DETAILS_ARGUMENT_KEY = "id"
const val DETAILS_ARGUMENT_NAME = "name"

sealed class Screen (val route : String){
    object Home : Screen(route = "home_screen")

    /*object Detail : Screen(route = "detail_screen/{$DETAILS_ARGUMENT_KEY}/{$DETAILS_ARGUMENT_NAME}"){
        fun passId(id:Int) : String {
            return this.route.replace(oldValue = "{$DETAILS_ARGUMENT_KEY}", newValue = id.toString())
        }

        fun passName(
            id:Int,
            name:String
        ) : String {
            return "detail_screen/$id/$name"
        }
     }*/

    object Detail : Screen(route = "detail_screen?id={$DETAILS_ARGUMENT_KEY}&name={$DETAILS_ARGUMENT_NAME}"){
        /*fun passId(id:Int = 0) : String {
            return "detail_screen?id={$id}"
        }*/

        fun passNameAndID(
            id:Int = 0,
            name:String = "moe"
        ) : String {
            return "detail_screen?id=$id&name=$name"
        }
    }
}
