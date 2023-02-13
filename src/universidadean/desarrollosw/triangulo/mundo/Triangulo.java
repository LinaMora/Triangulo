/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad Ean (Bogotá - Colombia)
 * Departamento Tecnologías de la Información
 * Licenciado bajo el esquema Academic Free License version 2.1
 * <p>
 * Unidad de Estudio: Desarrollo de Software
 * Ejercicio: Triangulo
 * Fecha: Agosto 2022
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package universidadean.desarrollosw.triangulo.mundo;

/**
 * Clase que representa un triángulo.
 */
public class Triangulo {

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Primer punto del triángulo.
     */
    private Punto punto1;

    /**
     * Segundo punto del triángulo.
     */
    private Punto punto2;

    /**
     * Tercer punto del triángulo.
     */
    private Punto punto3;

    /**
     * Color de las líneas.
     */
    private Color colorLineas;

    /**
     * Color del relleno.
     */
    private Color colorRelleno;

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Inicializa el triángulo
     */
    public Triangulo() {
        // Inicializa los puntos

        punto1 = new Punto(200, 50);
        punto2 = new Punto(300, 200);
        punto3 = new Punto(100, 200);

        // Inicializa los colores
        colorRelleno = new Color(60, 168, 56);
        colorLineas = new Color(0, 83, 24);
    }

    /**
     * Retorna el punto 1 del triángulo.
     */
    public Punto darPunto1() {
        return punto1;
    }

    /**
     * Retorna el punto 2 del triángulo.
     */
    public Punto darPunto2() {
        return punto2;
    }

    /**
     * Retorna el punto 3 del triángulo.
     */
    public Punto darPunto3() {
        return punto3;
    }

    /**
     * Retorna el color de las líneas del triángulo.
     */
    public Color darColorLineas() {
        return colorLineas;
    }

    /**
     * Retorna el color del relleno del triángulo.
     */
    public Color darColorRelleno() {
        return colorRelleno;
    }

    /**
     * Retorna el perímetro del triángulo.
     */
    public double darPerimetro() {
        //TODO: Retorna la suma de todos los lados
        double ab = this.calcularLado1();
        double bc = this.calcularLado2();
        double ac = this.calcularLado3();

        double p = (ab+bc)+ ac;

        return p;
    }

    /**
     * Retorna el área del triángulo, calculada utilizando la formula de Herón. <br>
     */
    public double darArea() {
        // TODO: Obtener y retornar el area del triángulo
        double s = darPerimetro()/2;
        double area =Math.sqrt((s*(s-calcularLado1())*(s-calcularLado2())* (s-calcularLado3())));

        return area;
    }

    /**
     * Calcula la altura del triángulo, teniendo en cuenta como base la línea entre el punto 1 y 2. <br>
     * Tenga en cuenta que Área = (Base * Altura) / 2.
     *
     * alruta = area * 2 /base
     */
    public double darAltura() {
        // TODO: Obtener y retornar la altura del triángulo
        double altura = (darArea()*2)/calcularLado1();
        return altura;
    }

    /**
     * Calcula la distancia entre el punto 1 y 2.
     */
    private double calcularLado1() {
        double x1= punto1.darX();
        double y1= punto1.darY();
        double x2= punto2.darX();
        double y2= punto2.darY();

        double d = Math.sqrt(((x2-x1)*(x2-x1))+((y2-y1)*(y2-y1)));

        // calcula la distancia
        return d;
    }

    /**
     * Calcula la distancia entre el punto 2 y 3.
     */
    private double calcularLado2() {
        double x2= punto2.darX();
        double y2= punto2.darY();
        double x3= punto3.darX();
        double y3= punto3.darY();

        double p = Math.sqrt(((x3-x2)*(x3-x2))+((y3-y2)*(y3-y2)));

        return p;
    }

    /**
     * Calcula la distancia entre el punto 3 y 1.
     */
    private double calcularLado3() {
        double x3= punto3.darX();
        double y3= punto3.darY();
        double x1= punto1.darX();
        double y1= punto1.darY();

        double l = Math.sqrt(((x3-x1)*(x3-x1))+((y3-y1)*(y3-y1)));

        return l;
    }

    /**
     * Calcula el ángulo opuesto entre un vértice de referencia y los otros dos vértices de un triángulo.
     */
    public double calcularAnguloOpuesto(double pX1, double pY1, double pX2, double pY2, double pX3, double pY3) {
        // Ángulo 1
        double angulo1 = Math.atan2(pY2 - pY1, pX2 - pX1);

        // Ángulo 2
        double angulo2 = Math.atan2(pY3 - pY1, pX3 - pX1);

        // Garantiza que la diferencias de ángulos sea la más pequeña.
        if (Math.abs(angulo1 - angulo2) > Math.PI) {
            angulo1 = angulo1 < 0 ? angulo1 + 2.d * Math.PI : angulo1;
            angulo2 = angulo2 < 0 ? angulo2 + 2.d * Math.PI : angulo2;
        }

        // Calcula el ángulo opuesto
        double anguloOpuesto = (angulo1 + angulo2) / 2.d + Math.PI;
        anguloOpuesto = anguloOpuesto % (2.d * Math.PI);
        return anguloOpuesto;
    }

    /**
     * Cambia el valor de la coordenada X y Y del punto 1.
     */
    public void cambiarPunto1(double pX, double pY) {
        this.punto1 = new Punto(pX, pY);

    }

    /**
     * Cambia el valor de la coordenada X y Y del punto 2.
     */
    public void cambiarPunto2(double pX, double pY) {
        this.punto2 = new Punto(pX, pY);
    }

    /**
     * Cambia el valor de la coordenada X y Y del punto 3.
     */
    public void cambiarPunto3(double pX, double pY) {
        this.punto3 = new Punto(pX, pY);
    }

    /**
     * Cambia el color de relleno del triángulo.
     */
    public void cambiarColorRelleno(int pRojo, int pVerde, int pAzul) {
        colorRelleno.cambiarRojo(pRojo);
        colorRelleno.cambiarVerde(pVerde);
        colorRelleno.cambiarAzul(pAzul);
    }

    /**
     * Cambia el color de las líneas del triángulo.
     */
    public void cambiarColorLineas(int pRojo, int pVerde, int pAzul) {
        // TODO: Realice el cambio de los colores
        colorLineas.cambiarRojo(pRojo);
        colorLineas.cambiarVerde(pVerde);
        colorLineas.cambiarAzul(pAzul);
    }

    /**
     * Obtener el tipo de triángulo. Este puede ser:
     * - equilatero: los tres lados iguales
     * - isosceles: solo dos lados iguales
     * - escaleno: todos los lados diferentes.
     */
    public String tipo() {
        // TODO: Obtener y retornar el tipo del triangulo
        if (this.calcularLado1()==this.calcularLado2() && this.calcularLado2()== this.calcularLado3()){
            return "Equilatero";
        }
        else if (this.calcularLado1()!=this.calcularLado2() && this.calcularLado2()!= this.calcularLado3()){
            return "Escaleno";
        }
        else {
            return "Isosceles";
        }

    }

    /**
     * Obtener el ángulo (en radianes) entre el lado 1 y el lado 2.
     * Use la ley del coseno para tal fin
     */
    public double angulo1() {
        // TODO: Obtener y retornar el ángulo entre los lado 1 y lado 2
        double a2 = this.calcularLado1()*this.calcularLado1();
        double b2 = this.calcularLado2()*this.calcularLado2();
        double c2 = this.calcularLado3()*this.calcularLado3();

        double bc2 = 2*calcularLado2()*calcularLado3();
        double cosX= ((b2+c2)-a2)/bc2;
        double angulo = Math.acos(cosX);
        return angulo;
    }

    /**
     * Obtener el ángulo (en radianes) entre el lado 2 y el lado 3.
     * Use la ley del coseno para tal fin
     */
    public double angulo2() {
        // TODO: Obtener y retornar el ángulo entre los lado 2 y lado 3
        double a2 = this.calcularLado1()*this.calcularLado1();
        double b2 = this.calcularLado2()*this.calcularLado2();
        double c2 = this.calcularLado3()*this.calcularLado3();

        double ac2 = 2*calcularLado1()*calcularLado3();
        double cosX= ((a2+c2)-b2)/ac2;
        double angulo = Math.acos(cosX);
        return angulo;

    }

    /**
     * Obtener el ángulo (en radianes) entre el lado 1 y el lado 3.
     * Use la ley del coseno para tal fin
     */
    public double angulo3() {
        // TODO: Obtener y retornar el ángulo entre los lado 1 y lado 3
        double a2 = this.calcularLado1()*this.calcularLado1();
        double b2 = this.calcularLado2()*this.calcularLado2();
        double c2 = this.calcularLado3()*this.calcularLado3();

        double ab2 = 2*calcularLado1()*calcularLado2();
        double cosX= ((a2+b2)-c2)/ab2;
        double angulo = Math.acos(cosX);
        return angulo;
    }
}
