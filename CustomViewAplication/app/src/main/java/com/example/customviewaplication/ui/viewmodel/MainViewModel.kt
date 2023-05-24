package com.example.customviewaplication.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.customviewaplication.data.CondoUnit

class MainViewModel : ViewModel() {
    var filteredList: List<CondoUnit> = listOf()

    private val _unitiesList: MutableList<CondoUnit> = mockCondoUnitView()
    val unitiesList: List<CondoUnit> = _unitiesList

    fun onQueryChanged(query: String) {
        this.filteredList = _unitiesList.filter { unit -> unit.unityName.contains(query) }
    }

    private fun mockCondoUnitView(): MutableList<CondoUnit> {
        return mutableListOf(
            CondoUnit(
                id = "1",
                unityName = "Mountain Ranch Luxury",
                unityDescription = "Aspen Grove Ranch is a truly elegant Colorado estate with out-of-this-world Rocky Mountain views.",
                url = "https://www.mountainliving.com/content/uploads/data-import/9882388e/ColoradoRanch0614Exterior0157-fdc41d50.jpg"
            ),
            CondoUnit(
                id = "2",
                unityName = "A Castle on a Hill",
                unityDescription = "Constructed by local craftsmen from indigenous stone and hand-hewn timbers, Montana’s Great Northern Lodge was built for the ages.",
                url = "https://www.mountainliving.com/content/uploads/data-import/9882388e/Centreoverall-935f2062.jpg"
            ),
            CondoUnit(
                id = "3",
                unityName = "Montana Home",
                unityDescription = "Simplicity and structure abound in this site-sensitive home in Big Sky.",
                url = "https://www.mountainliving.com/content/uploads/data-import/9882388e/Peers-Homesteadext1.jpg"
            ),
            CondoUnit(
                id = "4",
                unityName = "Ultra-Modern Home",
                unityDescription = "This abode overlooking Rattlesnake Valley is referred to as a “60-year-old’s bachelor pad” by its newly retired homeowners.",
                url = "https://www.mountainliving.com/content/uploads/data-import/9882388e/Elisonopen-f0932770.jpg"
            ),
            CondoUnit(
                id = "5",
                unityName = "A Summer Cabin, Redefined",
                unityDescription = "A modern take on a Montana tradition, inspired by the music of a cascading creek.",
                url = "https://www.mountainliving.com/content/uploads/data-import/9882388e/deer-lodgeext1.jpg"
            ),
            CondoUnit(
                id = "6",
                unityName = "Cabin in Pagosa Springs",
                unityDescription = "Handcrafted finishes create the feeling of old-school rustic living with all the comforts of a modern home.",
                url = "https://www.mountainliving.com/content/uploads/data-import/9882388e/Pagosaext-9d37cae1.jpg"
            )

        )
    }
}