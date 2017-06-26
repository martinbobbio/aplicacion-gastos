package bobbio.martin.a00_agendagastos;

import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;

public class Preferencias extends PreferenceActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferencias);

    }

}
