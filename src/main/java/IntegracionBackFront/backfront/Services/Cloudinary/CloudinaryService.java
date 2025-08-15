package IntegracionBackFront.backfront.Services.Cloudinary;


import com.cloudinary.Cloudinary;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;

@Service
public class CloudinaryService {

    //1.Definir el tamaaño de las imagenes en MB
    private static final long MAX_FILE_SIZE = 5 * 1024;
    //2 Definimos las extensiones permitidos
    private static final String[] ALLOWED_EXTENSIONS = {".jpg",".jpeg", ".png"};
    //3.Atributo Cloudinary
    private final Cloudinary cloudinary;

    //Constructor para inyeccion de dependencia Cloudinary

    public CloudinaryService(Cloudinary cloudinary){
        this.cloudinary = cloudinary;
    }
         public String uploadImage(MultipartFile file) throws IOException{
                 validateImage(file);
         }

    private void validateImage(MultipartFile file) {
        //1.Verificar si el archivo esta vacio
        if (file.isEmpty()){
            throw new IllegalArgumentException("El archivo esta vacio.");
        }
        //2 Verificamos si el tamaño excede el limite permitido
        if (file.getSize() > MAX_FILE_SIZE){
            throw new IllegalArgumentException("El tamaño del archivo no debe ser mayor a 5MB");
        }
        //3.VERIFICAMOS EL NOMBRE ORIGINAL DEL ARCHIVO
        String originalFileName = file.getOriginalFilename();
        if (originalFileName == null){
            throw new IllegalArgumentException("Nombre de archivo invalido");
        }
        //4EXTRAEMOS Y VALIDAMOS LA EXTENSION DEL ARCHIVO
        String extension= originalFileName.substring(originalFileName.lastIndexOf(".")).toLowerCase();
        if (!Arrays.asList(ALLOWED_EXTENSIONS).contains(extension)){
            throw new IllegalArgumentException("Solo se permite archivos JPG,JPEG,PNG");
        }

    }
}
