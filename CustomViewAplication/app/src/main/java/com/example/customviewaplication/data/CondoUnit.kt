package com.example.customviewaplication.data

data class CondoUnit(
    var id: String,
    var unitName: String,
    var unitDescription: String,
    var unitPicture: String,
    var residents: List<Residents>
)

