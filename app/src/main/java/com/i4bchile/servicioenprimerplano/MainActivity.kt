package com.i4bchile.servicioenprimerplano

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Message
import com.i4bchile.servicioenprimerplano.databinding.ActivityMainBinding


/*
[x] 1. Crear proyecto android, api mínima 21, targetSdk 29.
[x] 2. Modificar diseño layout por defecto activity_main.xml para incluir el TextView y el botón.
        [] TexView con el contador del número de ejecuciones
        [] Botón para iniciar o detener el servicio
[x] 3. Habilitar el enlace de las vistas con MainActivity usando view binding
[] 4. Crear la clase ForegroundService que extienda de Service e implementar los callbacks necesarios.
[] 5. Declarar en el manifesto la clase ForegroundService dentro de app.
[] 6. Indicar el permiso para ejecución del servicio usando . en Manifest
[] 7. MainActivity implementa la interfaz Handler.Callback para registrarse con el servicio y que sea
notificado cuando ocurra un evento, implementando handleMessage().
[] 8. Enlazar las vistas de ser necesario.
[] 9. Agregar la funcionalidad de onClickListener al botón para iniciar/detener el servicio.
[] 10. Probar la app usando AVD, otro emulador o un dispositivo físico.
 */



class MainActivity : AppCompatActivity(), Handler.Callback {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding= ActivityMainBinding.inflate(layoutInflater)



        setContentView(binding.root)
    }

    override fun handleMessage(msg: Message): Boolean {
        TODO("Not yet implemented")
    }
}