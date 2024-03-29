package com.example.diy4rent.demo.controllers;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

//import org.apache.el.stream.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.ui.Model;
//import org.springframework.http.codec.multipart.FormData;

import java.io.IOException;
import java.util.List;
import com.example.diy4rent.demo.model.*;
import com.example.diy4rent.demo.repo.ICarritoRepo;
import com.example.diy4rent.demo.repo.IHerramientaRepo;
import com.example.diy4rent.demo.repo.IUsuarioRepo;
import com.example.diy4rent.demo.service.HerramientaService;

import jakarta.servlet.http.HttpSession;

@RestController
public class controller {

    /*
     * Autor: Sofía Pita Miguélez
     */

    @Autowired
    private IHerramientaRepo repo;
    @Autowired
    private IUsuarioRepo repoUsuarios;
    @Autowired
    private ICarritoRepo carritoRepo;

    private HerramientaService herramientaService;

    @GetMapping(value = "/")
    public ModelAndView getIndex(HttpSession session) {
        ModelAndView modelAndView = new ModelAndView("index.html");
        List<Herramientas> herramientas = repo.findAll();
        modelAndView.addObject("herramientas", herramientas);

        // Agrega el nombre de usuario a la vista
        Usuarios usuario = (Usuarios) session.getAttribute("usuario");
        String nombreUsuario = (usuario != null) ? usuario.getNombre() : "usuario sin registrar";
        modelAndView.addObject("nombreUsuario", nombreUsuario);
        return modelAndView;
    }

    @GetMapping(value = "/herramientas")
    public ModelAndView getHerramientas() {
        ModelAndView modelAndView = new ModelAndView("herramientas.html");
        List<Herramientas> herramientas = repo.findAll();
        // System.out.println("Working view");
        // System.out.println(herramientas.get(0).getUuid());
        modelAndView.addObject("herramientas", herramientas);
        modelAndView.addObject("uuid", herramientas.get(0).getPhoto());
        return modelAndView;
    }

    @GetMapping(value = "/register")
    public ModelAndView getRegister() {
        ModelAndView modelAndView = new ModelAndView("register.html");
        return modelAndView;
    }

    @PostMapping(value = "/register")
    public ModelAndView addUsuario(@RequestParam("email") String email, @RequestParam("dni") String dni,
            @RequestParam("password") String password, @RequestParam("nombre") String nombre,
            @RequestParam("apellido1") String apellido1, @RequestParam("apellido2") String apellido2,
            @RequestParam("movil") String movil, @RequestParam("location") String location,
            @RequestParam("charge_info") String charge_info) {
        // System.out.println("Funciona!!!");
        Usuarios usuario = new Usuarios(email, dni, password, nombre, apellido1, apellido2, movil, location,
                charge_info);
        repoUsuarios.save(usuario);
        ModelAndView modelAndView = new ModelAndView("reg_correcto.html");
        return modelAndView;
    }

    @GetMapping(value = "/form")
    public ModelAndView uploadHerramienta() {
        ModelAndView modelAndView = new ModelAndView("form.html");
        modelAndView.addObject("herramienta", new Herramientas());
        return modelAndView;
    }

    // SPRINT 2 Definicion @PostMapping(value = "/form")

    /*
     * @PostMapping(value = "/form")
     * public ModelAndView addHerramienta(@RequestParam("title") String title,
     * 
     * @RequestParam("description") String description, @RequestParam("price") Float
     * price,
     * 
     * @RequestParam("photo") MultipartFile photo, @RequestParam("category") String
     * category,
     * 
     * @RequestParam("location") String location, @RequestParam("charge_info")
     * String charge_info) {
     * System.out.println("Correctly: " + photo.toString());
     * // Default Dummy image
     * String hexBinaryImage =
     * "ffd8ffe000104a46494600010101006000600000fffe003e43524541544f523a2067642d6a7065672076312e3020287573696e6720494a47204a50454720763830292c2064656661756c74207175616c6974790affdb004300080606070605080707070909080a0c140d0c0b0b0c1912130f141d1a1f1e1d1a1c1c20242e2720222c231c1c2837292c30313434341f27393d38323c2e333432ffdb0043010909090c0b0c180d0d1832211c213232323232323232323232323232323232323232323232323232323232323232323232323232323232323232323232323232ffc0001108012c01c203012200021101031101ffc4001f0000010501010101010100000000000000000102030405060708090a0bffc400b5100002010303020403050504040000017d01020300041105122131410613516107227114328191a1082342b1c11552d1f02433627282090a161718191a25262728292a3435363738393a434445464748494a535455565758595a636465666768696a737475767778797a838485868788898a92939495969798999aa2a3a4a5a6a7a8a9aab2b3b4b5b6b7b8b9bac2c3c4c5c6c7c8c9cad2d3d4d5d6d7d8d9dae1e2e3e4e5e6e7e8e9eaf1f2f3f4f5f6f7f8f9faffc4001f0100030101010101010101010000000000000102030405060708090a0bffc400b51100020102040403040705040400010277000102031104052131061241510761711322328108144291a1b1c109233352f0156272d10a162434e125f11718191a262728292a35363738393a434445464748494a535455565758595a636465666768696a737475767778797a82838485868788898a92939495969798999aa2a3a4a5a6a7a8a9aab2b3b4b5b6b7b8b9bac2c3c4c5c6c7c8c9cad2d3d4d5d6d7d8d9dae2e3e4e5e6e7e8e9eaf2f3f4f5f6f7f8f9faffda000c03010002110311003f00f61a28a2ac90a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28aaba85fc3a6d8c9753b611074eec7b01401475df10dbe869187432cd21e2356c1c7a9ad8ae1758b0987876eb54bf1fe9b74e876ff00cf24cf083f4aeea8021bbb816b673dc15dc228d9c8ce33819ac483c43a85cc09343a0cef1b8cab099791f955ff00103ecf0fdf9ffa62c3f318a7e889e5e8560bff004ee87f35068028ff006d6abff42f5c7fdfe5ff000ad8b69249ada392584c2ecb968c9c953e952d14015afefedf4db46b9ba93646bf993e83deb2575ad5ee544969a0c8613cab4d3ac6cc3e87a543320d5bc6420939b7d3a30e50f4323608fe9f9574b4018d67e20596f56c6fad65b1ba6fb8b21cabff00baddeb66b27c47a7aea1a34c00c4d0832c4c3aab0e78faf4a9f45bd3a8e8d6b74c72ee9f31ff0068707f506802fd14557bbbfb6b1111ba996212b8452dd33fd2802c514514005155a1bfb5b8ba9eda1995e6831e628fe1cd59a002b126f10979e4874ed3ae6f5e3628cc06c40476dc6b6e9000a300003da80308eabaec7f349a0653b88ee55987e1deaf695ac5b6ad1b9877a4b19c490c830c87dc5685738157fe13e260e3fd0ff7f8f5cf19f7fbb401d1d6149e2269ee648349b096fda3387903048c1f4dc7ad3bc557725b68ad1c27135cbac087fdeebfa035a3a758c5a6d8436908f9635c13fde3dc9fad0064bebf7f623ccd4f4696183f8a58651205f72074adcb7b88aea049e0916489c65597a114f650ca5580208c107bd739a0aff66eb9a968e09f2462e201fdd53d47ea3f2a00dfb8b88ad6dde79e411c4832cc7b56226bda85f2f99a6e8b2cb01fbb2cd288f77d01ea2a3d717fb4f5fd3f48627c800dc4e3fbc06703f43f9d7460050000001c0028030e2f11343731dbeab612583c8708ecc1e327d370addaa9a95845a9e9f35a4a061d783fdd3d8d50f0b5e4977a1c6b31266b7630393eabd3f4228036a8a28a0028a28a0028a28a0028a28a0028a28a0028a28a0028a28a0028a28a0028a28a0028a28a0028a28a0028a28a0028a28a0028a28a000900124e00ae72dc1f116ac2edc674cb3622007a4d2776fa0edffeba5f15dd5c241059c30dc345704f9f24085995063207b9a583c45696d6f1c10e95a9a471a855516dd07e740078d3fe45b97fdf4fe75d0d715e27d763bed124816cafa225d4ef9a1daa307d735bb6de218aeae63816c35042e71ba4830a3ea7340897c436f3dd6837505b466495d405507afcc3fa551b5b1f104b690a3dfc3608881447144246c018f989eff4ae868a067393b6bfa3c6d72d7116a76e9cc886211b85ee463ffaf5b967770df5a4575036e8a45ca9a9c804104641ae77c187fe2492283944b8754fa71ffd7a00341f9bc41afb9393e722fe00357455cee9445bf8b759b66e0ca23993dc639fd5aba2a01084060411907835cff82d89f0e46a4e42c8e07e75b77738b5b39e76381146ce7f019ac9f084060f0d5b6ee0bee7fcc9c7e98a00dca82f2ce0bfb57b6b98c3c4e3041fe63dea7a28039bb3bc9f40ba4d375290bd9b9c5addb76ff61bfc7fa749753d4ee2f2ece93a430f3ffe5bdc0fbb02ff00f15fe7e916b77475795b43b08d25738fb44cc32b00ff00e2bfcfd21d2cff00c22d75fd9b78abf649df30dd818cb7f75fd3fcfe0c46f699a65be95682dedd7dddcfde73ea6ae5145218554d465bd8ad83585ba4f36e00abbed18f5cfe556e8a00e5aef50f1381f3e9e2087f8a4b702671f41bbfa55ff0e0d34dbccf6533cd3bb66e1e6ff5a5bfdaf4ef5b55ce5f28b3f19e9b343f29bb478e603f8801904fe9f95002f897e6d43438c9f94de293f8115d1573be2c3e4269b7a7eedbde2331f45eff00caba2eb400573d2fc9e3e8318f9ec486ff00be8ff80ae86b9d8ffd27c79330e96b68109f72738fc89a002dfe6f1edd927ee59803f12a6ba2ae7588b6f1ea96e05d59ed53eac0e7f92d745400573de18f96ef5a8c636adf39007d7ffad5d0f4ae77c25fbeb7d42f7b5cde3baf1d47f926803a2a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a28039ef1a7fc8b72ffbe9fceba1a28a00ad7f76d6568d3adbcb71b48ca4432d8ee40ace8bc59a348bf35d794c3aa488c08fd2b6aa3782294832448e47765068039fbcf117f68c6f67a1c72dccf20da660a5522cf724f7ad7d274e4d2b4c86cd0eed83e66fef31e49fceae2aaa28550001d0014b40185ae58dd25e5beafa72799736e0ac917fcf58fd3ebd7fc8a743e2cd2244fdeced6f20fbd1ca84329fcab6ea3782294832448e47765068039abebf93c4d8d3b4b59059b37fa45db290bb4765cf535d3430a5bc11c312ed8e350aa3d00a78000000c0145001543578f509ad043a73a47248c15e563ca2f723deafd14014f4cd32df4ab416f6ebeeee7ef39f5352de59c17f6af6d7318789c6083fcc7bd4f45006568d6ba858096d2e6459ad63c7d9e527e7dbfdd23dbfcfb6ad145001586be27b681bcad4e09ec25071fbc42c87e8c3ad6e5232aba9560083d4114018d278b34645caddf9ac7a2468c49f6e955f4db7bbd535afed8bcb76b78624296b0bfdee7ab11dbbfe75bc90431b6e8e2443eaaa05494015752b18f52d3a7b4938591700fa1ea0fe758963af1d2a35b0d715e09621b527da592551d0e477ae9691955d76b2861e84668030ae7c576017cbb02f7b74dc245121393ee71d2a6d034c9ac609ae2f1835edd3f99311dbd17f0ad58e28e2188e35407b28c53e8031f5fd367bc860b9b2205eda3f99167f8bd57f1a8adfc57a795d97c5ecae57878a543c1f638e95bb4c9218a518923471fed283401ce5feb8dabc6da7e86af3492fcb25c6d212253d793deb734eb18f4dd3e1b48b958d719c753dcfe26acaaaa28550001d0014b400514514005145140051451400514514005145140051451400514514005145140051451400514514005145140051451400514514005145140051451400514514005145140051451400514514005145140051451400514514005145140051451400514514005145140051451400514514005145140051451400514514005145140051451400514514005145140051451400514514005145140051451400514514005145140051451400514514005145140051451400514514005145140051451400514514005145140051451400514514005145140051451400514514005145140051451400514514005145140051451400514514005145140051451400514514005145140051451400514514005145140051451400514514005145140051451400514514005145140051451400514514005145140051451400514514005145140051451400514514005145140051451400514514005145140051451400514514005145140051451400514514005145140051451400514514005145140051451400514514005145140051451400514514005145140051451400514514005145140051451400514514005145140051451400514514005145140051451400514514005145140051451400514514005145140051451400514514005145140051451400514514005145140051451400514514005145140051451400514514005145140051451400514514005145140051451400514514005145140051451400514514005145140051451400514514005145140051451400514514005145140051451400514514005145140051451400514514005145140051451400514514005145140051451400514514005145140051451400514514005145140051451400514514005145140051451400514514005145140051451400514514005145140051451400514514005145140051451400514514005145140051451400514514005145140051451400514514005145140051451400514514005145140051451400514514005145140051451400514514005145140051451400514514005145140051451400514514005145140051451400514514005145140051451400514514005145140051451400514514005145140051451400514514005145140051451400514514005145140051451400514514005145140051451400514514005145140051451400514514005145140051451400514514005145140051451400514514005145140051451400514514005145140051451400514514005145140051451400514514005145140051451400514514005145140051451400514514005145140051451401ffd9";
     * byte[] hexBytes =
     * jakarta.xml.bind.DatatypeConverter.parseHexBinary(hexBinaryImage);
     * try {
     * byte[] bytes = photo.getBytes();
     * String hexBinary = jakarta.xml.bind.DatatypeConverter.printHexBinary(bytes);
     * hexBytes = jakarta.xml.bind.DatatypeConverter.parseHexBinary(hexBinary);
     * } catch (IOException e) {
     * e.printStackTrace();
     * }
     * Herramientas herramienta = new Herramientas(title, description, (float)
     * price, hexBytes, category, location,
     * charge_info);
     * repo.save(herramienta);
     * ModelAndView modelAndView = new ModelAndView("reg_correcto.html");
     * return modelAndView;
     * }
     */
    // ESTE ES DEL SPRINT 3

    @PostMapping(value = "/form")
    public ModelAndView addHerramienta(@RequestParam("title") String title,

            @RequestParam("description") String description, @RequestParam("price") Float price,

            @RequestParam("photo") MultipartFile photo, @RequestParam("category") String category,

            @RequestParam("location") String location, @RequestParam("charge_info") String charge_info) {
        System.out.println("Correctly uploaded photo: " +
                photo.getOriginalFilename());
        // System.out.println("Correctly: " + photo.toString());
        // Default Dummy image
        String hexBinaryImage = "ffd8ffe000104a46494600010101006000600000fffe003e43524541544f523a2067642d6a7065672076312e3020287573696e6720494a47204a50454720763830292c2064656661756c74207175616c6974790affdb004300080606070605080707070909080a0c140d0c0b0b0c1912130f141d1a1f1e1d1a1c1c20242e2720222c231c1c2837292c30313434341f27393d38323c2e333432ffdb0043010909090c0b0c180d0d1832211c213232323232323232323232323232323232323232323232323232323232323232323232323232323232323232323232323232ffc0001108012c01c203012200021101031101ffc4001f0000010501010101010100000000000000000102030405060708090a0bffc400b5100002010303020403050504040000017d01020300041105122131410613516107227114328191a1082342b1c11552d1f02433627282090a161718191a25262728292a3435363738393a434445464748494a535455565758595a636465666768696a737475767778797a838485868788898a92939495969798999aa2a3a4a5a6a7a8a9aab2b3b4b5b6b7b8b9bac2c3c4c5c6c7c8c9cad2d3d4d5d6d7d8d9dae1e2e3e4e5e6e7e8e9eaf1f2f3f4f5f6f7f8f9faffc4001f0100030101010101010101010000000000000102030405060708090a0bffc400b51100020102040403040705040400010277000102031104052131061241510761711322328108144291a1b1c109233352f0156272d10a162434e125f11718191a262728292a35363738393a434445464748494a535455565758595a636465666768696a737475767778797a82838485868788898a92939495969798999aa2a3a4a5a6a7a8a9aab2b3b4b5b6b7b8b9bac2c3c4c5c6c7c8c9cad2d3d4d5d6d7d8d9dae2e3e4e5e6e7e8e9eaf2f3f4f5f6f7f8f9faffda000c03010002110311003f00f61a28a2ac90a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28aaba85fc3a6d8c9753b611074eec7b01401475df10dbe869187432cd21e2356c1c7a9ad8ae1758b0987876eb54bf1fe9b74e876ff00cf24cf083f4aeea8021bbb816b673dc15dc228d9c8ce33819ac483c43a85cc09343a0cef1b8cab099791f955ff00103ecf0fdf9ffa62c3f318a7e889e5e8560bff004ee87f35068028ff006d6abff42f5c7fdfe5ff000ad8b69249ada392584c2ecb968c9c953e952d14015afefedf4db46b9ba93646bf993e83deb2575ad5ee544969a0c8613cab4d3ac6cc3e87a543320d5bc6420939b7d3a30e50f4323608fe9f9574b4018d67e20596f56c6fad65b1ba6fb8b21cabff00baddeb66b27c47a7aea1a34c00c4d0832c4c3aab0e78faf4a9f45bd3a8e8d6b74c72ee9f31ff0068707f506802fd14557bbbfb6b1111ba996212b8452dd33fd2802c514514005155a1bfb5b8ba9eda1995e6831e628fe1cd59a002b126f10979e4874ed3ae6f5e3628cc06c40476dc6b6e9000a300003da80308eabaec7f349a0653b88ee55987e1deaf695ac5b6ad1b9877a4b19c490c830c87dc5685738157fe13e260e3fd0ff7f8f5cf19f7fbb401d1d6149e2269ee648349b096fda3387903048c1f4dc7ad3bc557725b68ad1c27135cbac087fdeebfa035a3a758c5a6d8436908f9635c13fde3dc9fad0064bebf7f623ccd4f4696183f8a58651205f72074adcb7b88aea049e0916489c65597a114f650ca5580208c107bd739a0aff66eb9a968e09f2462e201fdd53d47ea3f2a00dfb8b88ad6dde79e411c4832cc7b56226bda85f2f99a6e8b2cb01fbb2cd288f77d01ea2a3d717fb4f5fd3f48627c800dc4e3fbc06703f43f9d7460050000001c0028030e2f11343731dbeab612583c8708ecc1e327d370addaa9a95845a9e9f35a4a061d783fdd3d8d50f0b5e4977a1c6b31266b7630393eabd3f4228036a8a28a0028a28a0028a28a0028a28a0028a28a0028a28a0028a28a0028a28a0028a28a0028a28a0028a28a0028a28a0028a28a0028a28a000900124e00ae72dc1f116ac2edc674cb3622007a4d2776fa0edffeba5f15dd5c241059c30dc345704f9f24085995063207b9a583c45696d6f1c10e95a9a471a855516dd07e740078d3fe45b97fdf4fe75d0d715e27d763bed124816cafa225d4ef9a1daa307d735bb6de218aeae63816c35042e71ba4830a3ea7340897c436f3dd6837505b466495d405507afcc3fa551b5b1f104b690a3dfc3608881447144246c018f989eff4ae868a067393b6bfa3c6d72d7116a76e9cc886211b85ee463ffaf5b967770df5a4575036e8a45ca9a9c804104641ae77c187fe2492283944b8754fa71ffd7a00341f9bc41afb9393e722fe00357455cee9445bf8b759b66e0ca23993dc639fd5aba2a01084060411907835cff82d89f0e46a4e42c8e07e75b77738b5b39e76381146ce7f019ac9f084060f0d5b6ee0bee7fcc9c7e98a00dca82f2ce0bfb57b6b98c3c4e3041fe63dea7a28039bb3bc9f40ba4d375290bd9b9c5addb76ff61bfc7fa749753d4ee2f2ece93a430f3ffe5bdc0fbb02ff00f15fe7e916b77475795b43b08d25738fb44cc32b00ff00e2bfcfd21d2cff00c22d75fd9b78abf649df30dd818cb7f75fd3fcfe0c46f699a65be95682dedd7dddcfde73ea6ae5145218554d465bd8ad83585ba4f36e00abbed18f5cfe556e8a00e5aef50f1381f3e9e2087f8a4b702671f41bbfa55ff0e0d34dbccf6533cd3bb66e1e6ff5a5bfdaf4ef5b55ce5f28b3f19e9b343f29bb478e603f8801904fe9f95002f897e6d43438c9f94de293f8115d1573be2c3e4269b7a7eedbde2331f45eff00caba2eb400573d2fc9e3e8318f9ec486ff00be8ff80ae86b9d8ffd27c79330e96b68109f72738fc89a002dfe6f1edd927ee59803f12a6ba2ae7588b6f1ea96e05d59ed53eac0e7f92d745400573de18f96ef5a8c636adf39007d7ffad5d0f4ae77c25fbeb7d42f7b5cde3baf1d47f926803a2a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a28a28039ef1a7fc8b72ffbe9fceba1a28a00ad7f76d6568d3adbcb71b48ca4432d8ee40ace8bc59a348bf35d794c3aa488c08fd2b6aa3782294832448e47765068039fbcf117f68c6f67a1c72dccf20da660a5522cf724f7ad7d274e4d2b4c86cd0eed83e66fef31e49fceae2aaa28550001d0014b40185ae58dd25e5beafa72799736e0ac917fcf58fd3ebd7fc8a743e2cd2244fdeced6f20fbd1ca84329fcab6ea3782294832448e47765068039abebf93c4d8d3b4b59059b37fa45db290bb4765cf535d3430a5bc11c312ed8e350aa3d00a78000000c0145001543578f509ad043a73a47248c15e563ca2f723deafd14014f4cd32df4ab416f6ebeeee7ef39f5352de59c17f6af6d7318789c6083fcc7bd4f45006568d6ba858096d2e6459ad63c7d9e527e7dbfdd23dbfcfb6ad145001586be27b681bcad4e09ec25071fbc42c87e8c3ad6e5232aba9560083d4114018d278b34645caddf9ac7a2468c49f6e955f4db7bbd535afed8bcb76b78624296b0bfdee7ab11dbbfe75bc90431b6e8e2443eaaa05494015752b18f52d3a7b4938591700fa1ea0fe758963af1d2a35b0d715e09621b527da592551d0e477ae9691955d76b2861e84668030ae7c576017cbb02f7b74dc245121393ee71d2a6d034c9ac609ae2f1835edd3f99311dbd17f0ad58e28e2188e35407b28c53e8031f5fd367bc860b9b2205eda3f99167f8bd57f1a8adfc57a795d97c5ecae57878a543c1f638e95bb4c9218a518923471fed283401ce5feb8dabc6da7e86af3492fcb25c6d212253d793deb734eb18f4dd3e1b48b958d719c753dcfe26acaaaa28550001d0014b400514514005145140051451400514514005145140051451400514514005145140051451400514514005145140051451400514514005145140051451400514514005145140051451400514514005145140051451400514514005145140051451400514514005145140051451400514514005145140051451400514514005145140051451400514514005145140051451400514514005145140051451400514514005145140051451400514514005145140051451400514514005145140051451400514514005145140051451400514514005145140051451400514514005145140051451400514514005145140051451400514514005145140051451400514514005145140051451400514514005145140051451400514514005145140051451400514514005145140051451400514514005145140051451400514514005145140051451400514514005145140051451400514514005145140051451400514514005145140051451400514514005145140051451400514514005145140051451400514514005145140051451400514514005145140051451400514514005145140051451400514514005145140051451400514514005145140051451400514514005145140051451400514514005145140051451400514514005145140051451400514514005145140051451400514514005145140051451400514514005145140051451400514514005145140051451400514514005145140051451400514514005145140051451400514514005145140051451400514514005145140051451400514514005145140051451400514514005145140051451400514514005145140051451400514514005145140051451400514514005145140051451400514514005145140051451400514514005145140051451400514514005145140051451400514514005145140051451400514514005145140051451400514514005145140051451400514514005145140051451400514514005145140051451400514514005145140051451400514514005145140051451400514514005145140051451400514514005145140051451400514514005145140051451400514514005145140051451400514514005145140051451400514514005145140051451400514514005145140051451400514514005145140051451400514514005145140051451400514514005145140051451400514514005145140051451400514514005145140051451400514514005145140051451400514514005145140051451400514514005145140051451400514514005145140051451400514514005145140051451401ffd9";
        byte[] hexBytes = jakarta.xml.bind.DatatypeConverter.parseHexBinary(hexBinaryImage);
        try {
            byte[] bytes = photo.getBytes();
            String hexBinary = jakarta.xml.bind.DatatypeConverter.printHexBinary(bytes);
            hexBytes = jakarta.xml.bind.DatatypeConverter.parseHexBinary(hexBinary);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Herramientas herramienta = new Herramientas(title, description, (float) price, hexBytes, category, location,
                charge_info);
        repo.save(herramienta);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("herramienta", herramienta);

        modelAndView.setViewName("preview");

        return modelAndView;
    }

    // ESTE ES DEL SPRINT 3

    @GetMapping("/preview")
    // he añadido lo que está en paréntesis en modelAttribute, si da error, lo quito
    public ModelAndView mostrarPrevisualizacion(@ModelAttribute("herramienta") Herramientas herramienta) {
        // mostrar los datos de la herramienta en la página
        ModelAndView modelAndView = new ModelAndView("preview");
        modelAndView.addObject("herramienta", herramienta);
        return modelAndView;
    }

    // ESTO ES SPRINT 3

    @PostMapping("/confirm")
    public ModelAndView guardarHerramienta(@ModelAttribute Herramientas herramienta) {
        // Si la herramienta no tiene ID asignado, generamos uno nuevo
        if (herramienta.getUuid() == null) {
            herramienta.setUuid(UUID.randomUUID().toString());
        }
        // repo.save(herramienta);
        ModelAndView modelAndView = new ModelAndView("redirect:http://localhost:8080/");
        return modelAndView; // Redirige al usuario a la página principal
    }

    // PROBANDO ESTAS NUEVAS RUTAS
    @GetMapping("/editar/{herramienta_uuid}")
    public ModelAndView mostrarFormularioEdicion(@PathVariable("herramienta_uuid") String herramienta_uuid) {
        // Obtener la herramienta correspondiente al UUID proporcionado
        Herramientas herramienta = repo.findByUuid(herramienta_uuid);
        if (herramienta == null) {
            throw new IllegalArgumentException("Herramienta no encontrada con UUID " + herramienta_uuid);
        }
        ModelAndView modelAndView = new ModelAndView("modform");
        modelAndView.addObject("herramienta", herramienta);
        return modelAndView;
    }

    /*
     * @PostMapping("/guardarCambios")
     * public ModelAndView guardarCambios(@ModelAttribute("herramienta")
     * Herramientas herramienta) {
     * // Guardar los cambios en la herramienta
     * repo.save(herramienta);
     * 
     * // Redirigir a la vista previa (preview.html)
     * ModelAndView modelAndView = new ModelAndView("redirect:/preview");
     * modelAndView.addObject("herramienta", herramienta);
     * return modelAndView;
     * }
     */
    @RequestMapping(value = "/guardarCambios", method = RequestMethod.POST)

    /* @PostMapping("/guardarCambios") */
    public ModelAndView guardarCambios(@ModelAttribute("herramienta") Herramientas herramienta) {
        // Si la herramienta no tiene ID asignado, generamos uno nuevo
        /*
         * if (herramienta.getUuid() == null) {
         * herramienta.setUuid(UUID.randomUUID().toString());
         * }
         */

        // Guardar los cambios en la herramienta
        repo.save(herramienta);

        // Redirigir a la vista previa (preview.html)
        ModelAndView modelAndView = new ModelAndView("redirect:/reg_correcto");
        /* modelAndView.addObject("herramienta", herramienta); */
        return modelAndView;
    }

    /*
     * @GetMapping("/editar/{uuid}")
     * public ModelAndView mostrarFormularioEdicion(@PathVariable("uuid") String
     * herramienta_uuid) {
     * // Obtener la herramienta correspondiente al ID proporcionado
     * Herramientas herramienta = repo.findByUuid(herramienta_uuid);
     * if (herramienta == null) {
     * throw new IllegalArgumentException("Herramienta no encontrada con UUID" +
     * herramienta_uuid);
     * }
     * // .orElseThrow(() -> new IllegalArgumentException("Herramienta no encontrada
     * // con ID: " + uuid));
     * ModelAndView modelAndView = new ModelAndView("modform");
     * // Agregar la herramienta al modelo
     * modelAndView.addObject("herramienta", herramienta);
     * 
     * // Mostrar el formulario de edición
     * return modelAndView;
     * }
     */

    @GetMapping("/modform/{uuid}")
    public ModelAndView mostrarFormularioModificacion(@PathVariable("uuid") String uuid) {
        Optional<Herramientas> herramientaOptional = repo.findById(uuid);
        if (herramientaOptional.isPresent()) {
            Herramientas herramientaExistente = herramientaOptional.get();
            ModelAndView modelAndView = new ModelAndView("modform");
            modelAndView.addObject("herramienta", herramientaExistente);
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("redirect:/");
            return modelAndView;
        }
    }
}
/*
 * @PostMapping("/herramienta/{id}/editar")
 * public String actualizarHerramienta(@PathVariable("id") String uuid,
 * 
 * @ModelAttribute Herramientas herramientaActualizada) {
 * // Obtener la herramienta correspondiente al ID proporcionado
 * Herramientas herramienta = repo.findById(uuid)
 * .orElseThrow(() -> new
 * IllegalArgumentException("Herramienta no encontrada con ID: " + uuid));
 * 
 * // Actualizar los datos de la herramienta con los valores del formulario
 * enviado
 * herramienta.setTitle(herramientaActualizada.getTitle());
 * herramienta.setDescription(herramientaActualizada.getDescription());
 * // ... actualizar el resto de los campos
 * herramienta.setCategory(herramientaActualizada.getCategory());
 * herramienta.setLocation(herramientaActualizada.getLocation());
 * herramienta.setPrice(herramientaActualizada.getPrice());
 * 
 * // Guardar los cambios en la base de datos
 * repo.save(herramienta);
 * 
 * // Redireccionar al índice de herramientas
 * return "redirect:/index";
 * }
 */
// no tengo claro que pasa con esto, de momento comentamos y probamos con la de
// arriba

/*
 * @GetMapping("/modform/{uuid}")
 * public ModelAndView mostrarFormularioModificacion(@PathVariable("uuid")
 * String uuid,
 * 
 * @ModelAttribute("herramienta") Herramientas herramienta) {
 * Optional<Herramientas> herramientaOptional = repo.findById(uuid);
 * if (herramientaOptional.isPresent()) {
 * Herramientas herramientaExistente = herramientaOptional.get();
 * herramientaExistente.setTitle(herramienta.getTitle());
 * herramientaExistente.setDescription(herramienta.getDescription());
 * herramientaExistente.setCategory(herramienta.getCategory());
 * herramientaExistente.setLocation(herramienta.getLocation());
 * herramientaExistente.setCharge_info(herramienta.getCharge_info());
 * // herramientaExistente.setPhoto(herramienta.getPhoto().getBytes());
 * herramientaExistente.setPrice(herramienta.getPrice());
 * repo.save(herramientaExistente);
 * ModelAndView modelAndView = new ModelAndView("modform");
 * modelAndView.addObject("herramienta", herramientaExistente);
 * return modelAndView;
 * } else {
 * ModelAndView modelAndView = new ModelAndView("redirect:/");
 * return modelAndView;
 * }
 */