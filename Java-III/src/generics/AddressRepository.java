package generics;

import generics.utils.FileUtil;
import generics.utils.FileUtil;

public class AddressRepository implements Repository<Address> {

    @Override
    public void write(Address address) {
        FileUtil<Address> fileUtil = new FileUtil<>(address);
        fileUtil.write("addresses.txt");
    }
}

