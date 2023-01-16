public class person {
    int done;
    String id,date,name,sname,wife,mname,fname,blood,job,single,oldsname,gender;
    person(String id,String name,String sname,String date,String wife,String mname,String fname,String blood,String job,String single,String oldsname,String gender){
        //super(id,date,name,sname,wife,mname,fname,blood,job,single,gender);
        this.id=id;
        this.date=date;
        this.name=name;
        this.sname=sname;
        this.wife=wife;
        this.mname=mname;
        this.fname=fname;
        this.blood=blood;
        this.job=job;
        this.single=single;
        this.oldsname=oldsname;
        this.gender=gender;
  
    }
    public String namesurname(){
        String nsname=name+" "+sname;
        return nsname;
    }
    person(){
        
    }
}
