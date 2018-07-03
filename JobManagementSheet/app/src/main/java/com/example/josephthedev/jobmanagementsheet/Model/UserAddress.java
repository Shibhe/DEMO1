package com.example.josephthedev.jobmanagementsheet.Model;

class UserAddress {
    private String Addr_Province;
    private String Addr_Street;
    private String Addr_Postal_Code;
    private AddrLocation location;

    public String getAddr_Province() {
        return Addr_Province;
    }

    public void setAddr_Province(String addr_Province) {
        Addr_Province = addr_Province;
    }

    public String getAddr_Street() {
        return Addr_Street;
    }

    public void setAddr_Street(String addr_Street) {
        Addr_Street = addr_Street;
    }

    public String getAddr_Postal_Code() {
        return Addr_Postal_Code;
    }

    public void setAddr_Postal_Code(String addr_Postal_Code) {
        Addr_Postal_Code = addr_Postal_Code;
    }

    public AddrLocation getLocation() {
        return location;
    }

    public void setLocation(AddrLocation location) {
        this.location = location;
    }
}
