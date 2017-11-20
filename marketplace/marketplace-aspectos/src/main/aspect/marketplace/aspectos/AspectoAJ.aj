package marketplace.aspectos;

public aspect AspectoAJ {//* com.yourpackage..*.*(..)
    pointcut metodoBar(): execution(* guardar(..));

    before(): metodoBar() {
        System.out.printf("Advice antes de método UsuarioServicio.guardar \n", thisJoinPoint.getSignature());
    }

    after(): metodoBar() {
        System.out.printf("Advice después de método UsuarioServicio.guardar \n", thisJoinPoint.getSignature());
    }
}