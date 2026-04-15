package domain;

public class Marca {
    private String Nombre;
    private String Pais;

    public Marca() {
    }

    public Marca(String Nombre, String Pais) {
        this.Nombre = Nombre;
        this.Pais = Pais;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getPais() {
        return Pais;
    }

    public void setPais(String Pais) {
        this.Pais = Pais;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Marca)) return false;
        Marca other = (Marca) obj;
        return this.Nombre.equals(other.Nombre) && this.Pais.equals(other.Pais);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(Nombre, Pais);
    }
}
