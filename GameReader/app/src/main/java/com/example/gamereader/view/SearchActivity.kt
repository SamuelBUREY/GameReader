package com.example.gamereader.view

import android.app.SearchManager
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import com.example.gamereader.R

class SearchActivity : AppCompatActivity(),SearchView.OnQueryTextListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.search_activity)


    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.options_menu, menu)

        val searchManager = getSystemService(Context.SEARCH_SERVICE) as SearchManager
        (menu.findItem(R.id.search).actionView as SearchView).apply {
            setSearchableInfo(searchManager.getSearchableInfo(componentName))

        }
        var searchMenuItem = menu.findItem(R.id.search)
        var searchview :SearchView= searchMenuItem.actionView as SearchView
        searchview.setOnQueryTextListener(this)
        searchview.isSubmitButtonEnabled=true
        return true

    }

    override fun onQueryTextSubmit(query: String?): Boolean {

        Log.d("SEARCH","test research"+ query)
        return true
    }


    override fun onQueryTextChange(newText: String?): Boolean {
        return false;
    }

}
