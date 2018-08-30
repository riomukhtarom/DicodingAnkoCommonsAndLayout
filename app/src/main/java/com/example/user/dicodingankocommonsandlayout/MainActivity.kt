package com.example.user.dicodingankocommonsandlayout

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import com.example.user.dicodingankocommonsandlayout.R.color.colorAccent
import org.jetbrains.anko.*
import org.jetbrains.anko.design.snackbar
import org.jetbrains.anko.sdk25.coroutines.onClick

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        MainActivityUI().setContentView(this)
    }
    class MainActivityUI : AnkoComponent<MainActivity>{
        override fun createView(ui: AnkoContext<MainActivity>) = with(ui){
            verticalLayout{
                padding = dip(16)
                val name = editText {
                    hint = "What's your name?"
                }
                button("Say Hello") {
                    backgroundColor = ContextCompat.getColor(context, colorAccent)
                    textColor = Color.WHITE
                    onClick { toast("Hello, ${name.text}!") }
                }.lparams(width = matchParent){
                    topMargin = dip(5)
                }

                button("Show Alert") {
                    backgroundColor = ContextCompat.getColor(context, colorAccent)
                    textColor = Color.WHITE

                    onClick {
                        alert("Happy Coding!", "Hello, ${name.text}!"){
                            yesButton { toast("Oh") }
                            noButton {  }
                        }.show()
                    }
                }.lparams(width = matchParent){
                    topMargin = dip(5)
                }

                button("Show Snackbar"){
                    backgroundColor = ContextCompat.getColor(context, colorAccent)
                    textColor = Color.WHITE

                    onClick{
                        snackbar(name, "Hello, ${name.text}!")
                    }
                }.lparams(width = matchParent){
                    topMargin = dip(5)
                }

                button("Show Progress Bar"){
                    backgroundColor = ContextCompat.getColor(context, colorAccent)
                    textColor = Color.WHITE

                    onClick {
                        indeterminateProgressDialog("Hello, ${name.text}! Please wait..").show()
                    }
                }.lparams(width = matchParent){
                    topMargin = dip(5)
                }

                button("Go To Second Activity"){
                    backgroundColor = ContextCompat.getColor(context, colorAccent)
                    textColor = Color.WHITE

                    onClick {
                        startActivity<SecondActivity>("name" to "${name.text}")
                    }
                }.lparams(width = matchParent){
                    topMargin = dip(5)
                }
            }
        }
    }
}
