package com.example.http.annotion.request.host;

public interface HostManager{
    IHost jhost = new IHost() {
        @Override//CA机构颁发证书，可以访问，自定义证书不可以访问,支持OK HTTP
        public String getHost() {
            return "https://v.juhe.cn";
        }

        @Override
        public String getDefaultPath() {
            return "/joke/content/list.php";
        }
    };
}
