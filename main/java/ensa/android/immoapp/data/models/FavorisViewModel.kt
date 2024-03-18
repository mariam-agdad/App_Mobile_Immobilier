package com.example.favorisannonce

import androidx.lifecycle.ViewModel
import ensa.android.immoapp.data.models.Annonce

class FavorisViewModel : ViewModel() {
    private val _favoris = mutableSetOf<Annonce>()
    val favoris: Set<Annonce> = _favoris

    fun toggleFavori(annonce: Annonce) {
        if (_favoris.contains(annonce)) {
            _favoris.remove(annonce)
        } else {
            _favoris.add(annonce)
        }
    }

    fun isFavori(annonce: Annonce): Boolean {
        return _favoris.contains(annonce)
    }
}
