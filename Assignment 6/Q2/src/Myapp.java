Import org.springframework.context.applicationcontext;
        Import org.springframework.context.support.classpathxmlapplicationcontext;

        Public class myapp {
    public static void main(string[] args) {
        applicationcontext context = new classpathxmlapplicationcontext("applicationcontext.xml");
        myservice myservice = (myservice) context.getbean("myservice");
        myservice.sayhello();
    }
}

Public interface myservice {
    void sayhello();
}

Public class myserviceimpl implements myservice {
    @override
    public void sayhello() {
        system.out.println("hello, world!");
    }
}
