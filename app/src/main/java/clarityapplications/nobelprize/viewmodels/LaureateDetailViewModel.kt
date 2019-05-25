package clarityapplications.nobelprize.viewmodels

import android.arch.lifecycle.ViewModel
import clarityapplications.nobelprize.managers.LaureateManager
import clarityapplications.nobelprize.models.Laureate

class LaureateDetailViewModel : ViewModel() {

    fun getLaureateById(id: Int): Laureate? {
        return LaureateManager.getLaureateById(id)
    }
}