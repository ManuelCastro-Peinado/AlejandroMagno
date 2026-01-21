package es.studium.alejandromagnoapp.ui.legado;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class LegadoViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public LegadoViewModel() {
        mText = new MutableLiveData<>();
    }

    public LiveData<String> getText() {
        return mText;
    }

    // Método para asignar el texto desde el Fragment
    public void setText(String texto) {
        mText.setValue(texto);
    }
}
