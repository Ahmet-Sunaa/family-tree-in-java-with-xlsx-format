import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
public class tree {
    private node root;
    private node saveroot;
    List<node> list = new ArrayList<node>();
    List<String> howclosetree = new ArrayList<String>();

    private class node {
        private node parent;
        private node left;
        private node right;
        private node down;
        private node wife;
        private int controller;
        public String id,name,sname,havewife,mname,fname,blood,job,single,gender;
        public String date;
        public int done;

        node(person a) {
            left = right = wife = down = null;
        }
    }
    
    public void insert(person a) throws ParseException {
        node n = new node(a);
        n.blood=a.blood;
        n.id=a.id;
        n.name=a.name;
        n.sname=a.sname;
        n.havewife=a.wife;
        n.mname=a.mname;
        n.fname=a.fname;
        n.job=a.job;
        n.single=a.single;
        n.gender=a.gender;
        n.date=a.date;
        n.done=a.done;
        
        insert(root, n);
    }
    
    public void insertfm(person a,person b) throws ParseException {
        node n = new node(a);
        node w = new node(b);
        n.blood=a.blood;
        n.id=a.id;
        n.name=a.name;
        n.sname=a.sname;
        n.havewife=a.wife;
        n.mname=a.mname;
        n.fname=a.fname;
        n.job=a.job;
        n.single=a.single;
        n.gender=a.gender;
        n.date=a.date;
        
        w.blood=b.blood;
        w.id=b.id;
        w.name=b.name;
        w.sname=b.sname;
        w.havewife=b.wife;
        w.mname=b.mname;
        w.fname=b.fname;
        w.job=b.job;
        w.single=b.single;
        w.gender=b.gender;
        w.date=b.date;
        n.wife=w;
        insertfm(root, n,w);
    }
    
    private void insertfm(node r,node n,node w ){
        root=n;
        root.wife=w;
    }
    
    private void insert(node r, node n) throws ParseException {
        Random rand=new Random();
        int a=rand.nextInt(3);
        if (root == null){
            root=n;
        }
        else{
            if(r!=null&&(r.gender.equals("Erkek")&&r.single.equals("Evli"))){
                if(r.name.contains(n.fname)&&r.havewife.contains(n.mname)){
                    if (r.left == null) {
                        r.left = n;
                    }else if(r.right==null){
                        r.right=n;
                    }else if(r.down==null){
                        r.down=n;
                    }
                }
                else if(r.name.contains(n.mname)&&r.wife.name.contains(n.fname)){
                    if (r.left == null) {
                        r.left = n;
                    }else if(r.right==null){
                        r.right=n;
                    }else if(r.down==null){
                        r.down=n;
                    }
                }else {
                    if(r.left!=null&&((r.left.name.contains(n.mname)&&r.left.havewife.contains(n.fname))||(r.left.name.contains(n.fname)&&r.left.havewife.contains(n.mname))))
                        insert(r.left,n);
                    else if(r.down!=null&&((r.down.name.contains(n.mname)&&r.down.havewife.contains(n.fname))||(r.down.name.contains(n.fname)&&r.down.havewife.contains(n.mname))))
                        insert(r.down,n);
                    else if(r.right!=null&&((r.right.name.contains(n.mname)&&r.right.havewife.contains(n.fname))||(r.right.name.contains(n.fname)&&r.right.havewife.contains(n.mname))))
                        insert(r.right,n);
                    else if(a==2) 
                        insert(r.right,n);
                    else if(a==1)
                        insert(r.down,n);
                    else insert(r.left,n);
                }
            }
            else if(r!=null&&r.gender.equals("Kadın")&&r.single.equals("Evli")){
                if(r.name.contains(n.mname)&&r.havewife.contains(n.fname)){
                    if (r.left == null) {
                        r.left = n;
                    }else if(r.right==null){
                        r.right=n;
                    }else if(r.down==null){
                        r.down=n;
                    }
                
                }
                else if(r.name.contains(n.fname)&&r.wife.name.contains(n.mname)){
                    if (r.left == null) {
                        r.left = n;
                    }else if(r.right==null){
                        r.right=n;
                    }else if(r.down==null){
                        r.down=n;
                    }
                }else {
                    if(r.left!=null&&((r.left.name.contains(n.mname)&&r.left.havewife.contains(n.fname))||(r.left.name.contains(n.fname)&&r.left.havewife.contains(n.mname))))
                        insert(r.left,n);
                    else if(r.down!=null&&((r.down.name.contains(n.mname)&&r.down.havewife.contains(n.fname))||(r.down.name.contains(n.fname)&&r.down.havewife.contains(n.mname))))
                        insert(r.down,n);
                    else if(r.right!=null&&((r.right.name.contains(n.mname)&&r.right.havewife.contains(n.fname))||(r.right.name.contains(n.fname)&&r.right.havewife.contains(n.mname))))
                        insert(r.right,n);
                    else if(a==2) 
                        insert(r.right,n);
                    else if(a==1)
                        insert(r.down,n);
                    else insert(r.left,n);
                }
            }else {
                r=root;
                insert(r,n);
            }
        }
    }
    
    public void print(){
        saveroot=root;
        print(root);

    }
    
    private void print(node r) {
        if (r != null) {
            System.out.print(r.name +" "+r.sname+ ": ");
            System.out.println(r.havewife+" ");
            print(r.left);
            print(r.right);
            print(r.down);
        }
    }
    
    public void deepfa(int x) throws ParseException{
        deepfa(root,x);
    }
    private void deepfa(node n,int x) throws ParseException{
        root=saveroot;
        if((root.right.controller==x&&root.left.controller==x)||(root.right.controller==x&&root.down.controller==x&&root.left.controller==x))
            System.out.println("tarama bitti");
        else{
            if(n.left!=null&&n.left.controller!=x){
                n.left.parent=n;
                deepfa(n.left,x);
            }else if(n.down!=null&&n.down.controller!=x){
                n.down.parent=n;
                deepfa(n.down,x);
            }else if(n.right!=null&&n.right.controller!=x){
                n.right.parent=n;
                deepfa(n.right,x);
            }
            else{
                if(n.left==null&&n.right==null&&n.down==null){
                    System.out.println(n.name);
                    list.add(n);
                    
                }
                n.controller=x;
                if(n.parent.right!=null)
                    deepfa(n.parent,x);
                else if(n.parent.down!=null)
                    deepfa(n.parent,x);
                else{
                    deepfa(root,x);
                }
            }
        }
        
    }
    
    public void sortage() throws ParseException{
        SimpleDateFormat format=new SimpleDateFormat("dd-MM-yyyy");
        person erkek=new person();
        node n1=new node(erkek);
        node n2=new node(erkek);
        int i=0,a=0;
        int x=list.size();
        
        while(x>i){
            a=i;
            while(x>a){
                n1=list.get(i);
                n2=list.get(a);
                Date date1=format.parse(n1.date);
                Date date2=format.parse(n2.date);
                if(date1.after(date2)){//date1>date2
                    //System.out.println(n1.name+n1.date+"\n"+n2.name+n2.date+"\n");
                    list.add(i,n2);
                    list.remove(i+1);
                    list.add(a, n1);
                    list.remove(a+1);
                    
                }
                a++;
            }
            i++;
        }i=0;
        while(list.size()>i){
            n1=list.get(i);
            System.out.println(n1.name+" "+n1.sname);
            i++;
        }   
    }

    public void searchblood(String str){
        searchblood(str,root);
    }
    private void searchblood(String str,node r){
        if (r != null) {
            if(r.blood.contains(str))
                System.out.println(r.name+" "+r.sname);
            searchblood(str, r.left);
            searchblood(str, r.right);
            searchblood(str, r.down);
        }
    }

    public void searchjob(person str){
        searchjob(str, root);
    }
    private void searchjob(person str,node r){
        if(str.done!=1&&r!=null&&!str.id.contains(r.id)&&str.job!=null){
            if(root.wife!=null&&str.job.contains(root.wife.job)){
                System.out.println(str.name+" "+str.sname+" ata:"+root.wife.name+" "+root.wife.sname+" iş:"+str.job); 
                str.done=1; 
            }
            if(str.done!=1&&r.parent!=null &&str.job.contains(r.parent.job)){
                System.out.println(str.name+" "+str.sname+" ata:"+r.parent.name+r.parent.sname+" iş:"+str.job);
                str.done=1;
            }else{
                searchjob(str,r.left);
                searchjob(str,r.right);
                searchjob(str,r.down);
            }
        }
    }

    public void searchsamename(person str){
        searchsamename(str,root);
    }
    private void searchsamename(person str,node r){
        if (r != null) {
            if(r.name.contains(str.name)&&r.id!=str.id)
                System.out.println(r.name+" "+r.sname+":"+r.date);
            searchsamename(str, r.left);
            searchsamename(str, r.right);
            searchsamename(str, r.down);
        }
    }

    
    public void howclose(person p1,person p2,int x) throws ParseException{
        //int b = howmuchfamilyaftername(p1,x);
        x++;
        //int k = howmuchfamilyaftername(p2,x);
        node older=new node(p1);
        older.blood=p1.blood;
        older.id=p1.id;
        older.name=p1.name;
        older.sname=p1.sname;
        older.havewife=p1.wife;
        older.mname=p1.mname;
        older.fname=p1.fname;
        older.job=p1.job;
        older.single=p1.single;
        older.gender=p1.gender;
        older.date=p1.date;
        node younger=new node(p2);
        younger.blood=p2.blood;
        younger.id=p2.id;
        younger.name=p2.name;
        younger.sname=p2.sname;
        younger.havewife=p2.wife;
        younger.mname=p2.mname;
        younger.fname=p2.fname;
        younger.job=p2.job;
        younger.single=p2.single;
        younger.gender=p2.gender;
        younger.date=p2.date;
        howclose(0,0,saveroot,older,younger,x);
    }
    int a=0;
    private void howclose(int b,int k,node r,node older,node younger,int x) throws ParseException{
        if(r!=null){
            if(r.name==older.name&&r.sname==older.sname){
                r=older;
                //howclose(b,k,r,older,younger,x);
            }else if(r.left!=null&&r.left.done!=x){
                if(r.left.name.equals(older.name)&&r.left.sname.equals(older.sname)){
                    howclose(b, k, r.left, older, younger, x);
                }
            }else if(r.right!=null&&r.right.done!=x){
                if(r.right.name.equals(older.name)&&r.right.sname.equals(older.sname)){
                    howclose(b, k, r.right, older, younger, x);
                }
            }else if(r.down!=null&&r.down.done!=x){
                if(r.down.name.equals(older.name)&&r.down.sname.equals(older.sname)){
                    howclose(b, k, r.down, older, younger, x);
                }
            }else if(r.left==null&&r.down==null&&r.right==null){
                r.done = x;
                howclose(b, k, saveroot, older, younger, x);
            }
        }
        // System.out.println(b-k);
        /*if(b-k>0){
            switch(b-k){
                case 1:
                    if(younger.fname==older.name){
                        System.out.println(older.name+" "+younger.name+" in babasıdır.");
                    }else{
                        System.out.println(older.name+" "+younger.name+" in annesidir.");
                    }
                case 2:
                    if(younger.parent.fname==older.name&&younger.parent.gender.contains("Kadın"))
                        System.out.println(older.parent.name+" "+younger.name+" in annesinin babasıdır.");
                    else if(younger.parent.fname==older.name&&younger.parent.gender.contains("Erkek"))
                        System.out.println(older.parent.name+" "+younger.name+" in babasının babasıdır.");
                    else if(younger.parent.mname==older.name&&younger.parent.gender.contains("Kadın"))
                        System.out.println(older.parent.name+" "+younger.name+" in annesinin annesidir.");
                    else    
                        System.out.println(older.parent.name+" "+younger.name+" in babasının annesidir.");
                case 3:
                    
            }

        }
        else{
            System.out.println("*****************************");
        }*/
        //older=root;
        /*System.out.println(saveroot.left.name);
        System.out.println(saveroot.right.name);
        System.out.println(saveroot.down.name);
        if(older.left!=null&&older.left.done!=x){
            if(older.left.name==younger.name&&older.left.gender.contains("Kadın"))
                System.out.print("annesi");
            else if(older.left.name==younger.name&&older.left.gender.contains("Erkek"))
                System.out.println("babası");////////////////ana baba ilişkisini bulllll
            howclose(b,k,r,older,younger,x);
        }else if(older.right!=null&&older.right.done!=x){
            if(older.right.name==younger.name&&older.right.gender.contains("Kadın"))
                System.out.print("annesi");
            else if(older.right.name==younger.name&&older.right.gender.contains("Erkek"))
                System.out.println("babası");////////////////ana baba ilişkisini bulllll
                howclose(b,k,r,older,younger,x);
        }else if(older.down!=null&&older.down.done!=x){
            if(older.down.name==younger.name&&older.down.gender.contains("Kadın"))
                System.out.print("annesi");
            else if(older.down.name==younger.name&&older.down.gender.contains("Erkek"))
                System.out.println("babası");////////////////ana baba ilişkisini bulllll
            howclose(b,k,r,older,younger,x);
        }
        
        
        else if(r.done!=x&&r.left==null&&r.right==null&&r.down==null){
            r.done=x;
            howmuchfamily(saveroot,x);
        }else if (r.done!=x){
            System.out.println("saaaaaaaaaaa");
            if(r.left!=null&&r.left.done!=x){
                r.done=x;
                howmuchfamily(r.left,x);
            } 
            else if(r.right!=null&&r.right.done!=x){
                r.done=x;
                howmuchfamily(r.right, x);
            }
            else if(r.down!=null&&r.down.done!=x){
                r.done=x;
                howmuchfamily(r.down,x);
            }
        }else{
            System.out.println("hiiiiiiiii");
            howmuchfamily(saveroot, x);
        }*/
        /*
        if (r != null) {
            if(r.name==older.name&&a==0){
                older=r;
                a++;
                System.out.println(older.left.name+" "+older.left.sname+" "+older.left.gender);
                howclose(b,k,older,older,younger,x);
            }
            else{
                if(a==1&&r.done!=x&&r.left!=null){
                    if (r.left.name==younger.name&&r.gender.equals("kadın")){
                        howclosetree.add("annesi");
                    }else if(r.left.name==younger.name&&r.gender.equals("Erkek")){
                        howclosetree.add("babası");
                    }
                    else if(r.gender.equals("Kadın")){
                        howclosetree.add("annesinin");
                        howclose(b, k, r.left, older, younger, x);
                    }else if(r.gender.equals("Erkek")){
                        howclosetree.add("babasının");
                        howclose(b, k, r.left, older, younger, x);
                    }
                }else if(a==1&&r.done!=x&&r.right!=null){
                    if (r.right.name==younger.name&&r.gender.equals("kadın")){
                        howclosetree.add("annesi");
                    }else if(r.right.name==younger.name&&r.gender.equals("Erkek")){
                        howclosetree.add("babası");
                    }
                    else if(r.gender.equals("Kadın")){
                        howclosetree.add("annesinin");
                        howclose(b, k, r.right, older, younger, x);
                    }else if(r.gender.equals("Erkek")){
                        howclosetree.add("babasının");
                        howclose(b, k, r.right, older, younger, x);
                    }
                }else if(a==1&&r.done!=x&&r.down!=null){
                    if (r.down.name==younger.name&&r.gender.equals("kadın")){
                        howclosetree.add("annesi");
                    }else if(r.down.name==younger.name&&r.gender.equals("Erkek")){
                        howclosetree.add("babası");
                    }
                    else if(r.gender.equals("Kadın")){
                        howclosetree.add("annesinin");
                        howclose(b, k, r.down, older, younger, x);
                    }else if(r.gender.equals("Erkek")){
                        howclosetree.add("babasının");
                        howclose(b, k, r.down, older, younger, x);
                    }
                }else if(r.left==null&&r.right==null&&r.down==null){
                    r.done=x;
                    if(r.name.equals(younger.name)){
                        for (int i = 0; i < howclosetree.size(); i++) {
                            System.out.println(howclosetree.get(i));
                        }
                    }else{
                        for (int i = 0; i < howclosetree.size(); i++) {
                            howclosetree.remove(i);
                        }

                        howclose(b, k, older, older, younger, x);
                    }
                }
                
            }
            
            
        }*/
    

    }


    int finddeep=0;
    int howmuchfamilyafternamecontroller=0;
    static List<Integer> finddeep1 = new ArrayList<>();
    public void howmuchfamily(){
        int x=2;
        howmuchfamily(root,x);
        int i=0;
        int max=0;
        while(finddeep1.size()>i){
            if(max<finddeep1.get(i))
                max=finddeep1.get(i);
            i++;
        }
        System.out.println("en yüksek node:"+max);
        howmuchfamilyafternamecontroller=max;

    }
    private void howmuchfamily(node r,int x){
        if(r.left!=null&&r.left.done!=x){
            finddeep++;
            howmuchfamily(r.left,x);
        }else if(r.right!=null&&r.right.done!=x){
            finddeep++;
            howmuchfamily(r.right,x);
        }else if(r.down!=null&&r.down.done!=x){
            finddeep++;
            howmuchfamily(r.down,x);
        }
        else if(r.done!=x&&r.left==null&&r.right==null&&r.down==null){
            r.done=x;
            finddeep++;
            finddeep1.add(finddeep);
            finddeep=0;
            howmuchfamily(root,x);
        }else if (r.done!=x&&(r.left.done==x||r.right.done==x||r.down.done==x)){
            r.done=x;
            finddeep=0;
            howmuchfamily(root,x);
        }
        //else{System.out.println("done");}
    

    }

    public int howmuchfamilyaftername(person erkek,int x){
        node n = new node(erkek);
        n.blood=erkek.blood;
        n.id=erkek.id;
        n.name=erkek.name;
        n.sname=erkek.sname;
        n.havewife=erkek.wife;
        n.mname=erkek.mname;
        n.fname=erkek.fname;
        n.job=erkek.job;
        n.single=erkek.single;
        n.gender=erkek.gender;
        n.date=erkek.date;
        finddeep=0;
        int max=0,i=0;
        while(finddeep1.size()>i){
            if(finddeep1.get(i)>=0){
                finddeep1.remove(i);
                i--;
            }
            i++;
        }
        howmuchfamilyaftername(root,n,x);
        i=0;
        while(finddeep1.size()>i){
            if(max<finddeep1.get(i))
                max=finddeep1.get(i);
            i++;
        }
        return max;
    }
    private void howmuchfamilyaftername(node r,node n,int x){
        if(r.name.equals(n.name)&&r.sname.equals(n.sname)){
            root=r;
            howmuchfamily(root,x);
        }else{
            if(r.left!=null&&r.left.name==n.name&&r.left.sname==n.sname){
                root=r.left;
                howmuchfamily(root,x);
            }
            else if(r.down!=null&&r.down.name==n.name&&r.down.sname==n.sname){
                root=r.down;
                howmuchfamily(root,x);
            } 
            else if(r.right!=null&&r.right.name==n.name&&r.right.sname==n.sname){
                root=r.right;
                howmuchfamily(root,x);
            }
            else if(r.left==null&&r.right==null&&r.down==null){
                if(r.name==n.name&&r.sname==n.sname){
                    root=r;
                    howmuchfamily(root, x);
                }
                howmuchfamilyaftername(root,n,x);
            }else{
                if(r.left!=null&&r.left.done!=x){
                    r.left.done=x;
                    howmuchfamilyaftername(r.left,n, x);
                }
                else if(r.down!=null&&r.down.done!=x){
                    r.down.done=x;
                    howmuchfamilyaftername(r.down,n, x);
                }
                else if(r.right!=null&&r.right.done!=x){
                    r.right.done=x;
                    howmuchfamilyaftername(r.right,n, x);
                }
                else{
                    howmuchfamilyaftername(root, n, x);
                }
            }
        }
    }

}
   