package com.i4bchile.servicioenprimerplano

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.util.Log
import com.i4bchile.servicioenprimerplano.databinding.ActivityMainBinding


/*
[x] 1. Crear proyecto android, api mínima 21, targetSdk 29.
[x] 2. Modificar diseño layout por defecto activity_main.xml para incluir el TextView y el botón.
        [x] TexView con el contador del número de ejecuciones
        [x] Botón para iniciar o detener el servicio
[x] 3. Habilitar el enlace de las vistas con MainActivity usando view binding
[] 4. Crear la clase ForegroundService que extienda de Service e implementar los callbacks necesarios.
        [x] Crear la clase
        [] Implementar los callbacks
[x] 5. Declarar en el manifesto la clase ForegroundService dentro de app.
[x] 6. Indicar el permiso para ejecución del servicio usando . en Manifest
[] 7. MainActivity implementa la interfaz Handler.Callback para registrarse con el servicio y que sea
notificado cuando ocurra un evento, implementando handleMessage().
[] 8. Enlazar las vistas de ser necesario.
[] 9. Agregar la funcionalidad de onClickListener al botón para iniciar/detener el servicio.
[] 10. Probar la app usando AVD, otro emulador o un dispositivo físico.
 */



class MainActivity : AppCompatActivity(), Handler.Callback {
    lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)

        binding.btStartStop.setOnClickListener {
            //Aquí se implementan los métodos para iniciar y detener el servicio.
            //Cada 7 segundos se incrementa el contador y se actualiza la vista

            if (ForegroundService.running){

                ForegroundService.stopService(this)
                binding.btStartStop.text=getString(R.string.messsage_start)

            }
            else {
                ForegroundService.startService(this,getString(R.string.message_2_user),Handler(this))
                binding.btStartStop.text=getString(R.string.messsage_stop)

            }


        }



        setContentView(binding.root)
    }

    override fun handleMessage(msg: Message): Boolean {
        Log.d("MainActivity", "handleMessage: ${msg.data}")
        val count=msg.data.get("Contador")
        binding.tvCounter.text=count.toString()
        return true
    }
}