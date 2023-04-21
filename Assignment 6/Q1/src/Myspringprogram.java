Import org.springframework.context.applicationcontext;
        Import org.springframework.context.support.classpathxmlapplicationcontext;

        Public class myspringprogram {

    public static void main(string[] args) {

        applicationcontext context = new classpathxmlapplicationcontext("applicationcontext.xml");

        myservice myservice = (myservice) context.getbean("myservice");

        string result = myservice.sayhello("john");

        system.out.println(result);

    }
}
