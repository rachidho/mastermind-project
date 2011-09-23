package fr.norsys.dojo.annotation;

public @interface Colonne {
	String name() default "";
	int length() default 255;
}
