package com.sophos.certificacion.utest.tasks;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

import com.sophos.certificacion.utest.userinterface.RegistrarUsuarioIU;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.util.List;
import java.util.Map;

public class RegistrarUsuario implements Task {

    private List<Map<String,String>> datosRegistro;

    public RegistrarUsuario(List<Map<String, String>> datosRegistro) {
        this.datosRegistro = datosRegistro;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
       actor.attemptsTo(
               Click.on(RegistrarUsuarioIU.BTN_REGISTRARSE),
               WaitUntil.the(RegistrarUsuarioIU.LBL_PAGINA_REGISTRO,isVisible()),
               Enter.theValue(datosRegistro.get(0).get("nombre")).into(RegistrarUsuarioIU.TXT_NOMBRES),
               Enter.theValue(datosRegistro.get(0).get("apellido")).into(RegistrarUsuarioIU.TXT_APELLIDOS),
               Enter.theValue(datosRegistro.get(0).get("correo")).into(RegistrarUsuarioIU.TXT_CORREO),
               SelectFromOptions.byVisibleText(datosRegistro.get(0).get("med")).from(RegistrarUsuarioIU.SLC_MES),
               SelectFromOptions.byVisibleText(datosRegistro.get(0).get("dia")).from(RegistrarUsuarioIU.SLC_DIA),
               SelectFromOptions.byVisibleText(datosRegistro.get(0).get("anno")).from(RegistrarUsuarioIU.TXT_ANNO),
               Click.on(RegistrarUsuarioIU.BTN_SIGUIENTE),
               WaitUntil.the(RegistrarUsuarioIU.LBL_PAGINA_REGISTRO_STEP2,isVisible()),
               Enter.theValue(datosRegistro.get(0).get("ciudad")).into(RegistrarUsuarioIU.TXT_CIUDAD),
               Click.on(RegistrarUsuarioIU.TXT_CIUDAD_ESCOGIDA),
               Enter.theValue(datosRegistro.get(0).get("codigo")).into(RegistrarUsuarioIU.TXT_CODIGO_POSTAL),
               Click.on(RegistrarUsuarioIU.BTN_SIGUIENTE_DEVICES),
               WaitUntil.the(RegistrarUsuarioIU.LBL_PAGINA_REGISTRO_STEP3,isVisible()),
               Click.on(RegistrarUsuarioIU.BTN_SIGUIENTE_PAGINA),
               WaitUntil.the(RegistrarUsuarioIU.LBL_PAGINA_REGISTRO_STEP4,isVisible()),
               Enter.theValue(datosRegistro.get(0).get("contrasena")).into(RegistrarUsuarioIU.TXT_PASSWORD),
               Enter.theValue(datosRegistro.get(0).get("contrasena")).into(RegistrarUsuarioIU.TXT_CONFIRMAR_PASSWORD),
               Click.on(RegistrarUsuarioIU.CHK_ACEPTAR_UTEST),
               Click.on(RegistrarUsuarioIU.CHK_ACEPTAR_POLITICAS),
               Click.on(RegistrarUsuarioIU.BTN_COMPLETAR_REGISTRO)
       );
    }

    public static RegistrarUsuario con(List<Map<String,String>> datosRegistro){
        return Tasks.instrumented(RegistrarUsuario.class,datosRegistro);
    }


}
