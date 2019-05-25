package clarityapplications.nobelprize.viewmodels

import android.arch.lifecycle.ViewModel;
import clarityapplications.nobelprize.managers.LaureateManager
import clarityapplications.nobelprize.models.Laureate

class LaureatesViewModel : ViewModel() {

    fun getLaureates(): List<Laureate>? {
        return LaureateManager.getLaureates()
    }
}
