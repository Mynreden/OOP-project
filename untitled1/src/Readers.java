public class Readers{


    private String fullname;
    private int cardnumber;
    private String faculty;
    private String DateofBirth;
    private int telephone;
    public Readers(){

}
    public Readers(String fullname, int cardnumber, String faculty ,String DateofBirth,int telephone ) {
        this.fullname = fullname;
        this.cardnumber = cardnumber;
        this.faculty = faculty;
        this.DateofBirth = DateofBirth;
        this.telephone = telephone;

    }
    public void takebook(int booknumber){
        System.out.println( this.fullname + " took "+ booknumber+ "books");
    }

    public void takebook(String bookName){
        System.out.println( this.fullname + " took books: "+ bookName );
    }
    public void returnBook(int booknumber){
        System.out.println( this.fullname + " returned  "+ booknumber + "books");
    }

    public void returnBook(String bookName){
        System.out.println( this.fullname + " returned books: "+ bookName);
    }
    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }
    public int getCardnumber() {
        return cardnumber;
    }

    public void setCardnumber(int cardnumber) {
        this.cardnumber = cardnumber;
    }
    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }
    public String getDateofBirth() {
        return DateofBirth;
    }

    public void setDateofBirth(String dateofBirth) {
        DateofBirth = dateofBirth;
    }
    public int getTelephone() {
        return telephone;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }
}

