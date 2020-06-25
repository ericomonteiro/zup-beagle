package br.com.ztx.beagle_1.components.actions

import android.content.Context
import android.widget.Toast
import br.com.zup.beagle.action.Action

class CustomAction: Action {

    //TODO Remove action from constructor
    constructor(context: Context, message: String) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show()
    }

}