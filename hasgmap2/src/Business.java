public class Business {
    String user_id;
    String business_id;
    String text;
    String date;
    int complimentCount;

    public Business(){}
    public Business(String user_id, String business_id, String text, String date, int complimentCount){
        this.user_id = user_id;
        this.business_id = business_id;
        this.text = text;
        this.date = date;
        this.complimentCount = complimentCount;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getBusiness_id() {
        return business_id;
    }

    public void setBusiness_id(String business_id) {
        this.business_id = business_id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getComplimentCount() {
        return complimentCount;
    }

    public void setComplimentCount(int complimentCount) {
        this.complimentCount = complimentCount;
    }

    public String toString() {
        return "user_id: "+ this.user_id + " business_id: " + this.business_id + " text: " + this.text + " date: " + this.date;
    }
}
