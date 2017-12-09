package game_store;

import game_store.controllers.GameController;
import game_store.controllers.ItemController;
import game_store.controllers.UserController;
import game_store.repositories.GameRepository;
import game_store.repositories.OrderRepository;
import game_store.repositories.UserRepository;
import game_store.services.api.GameService;
import game_store.services.api.OrderService;
import game_store.services.impl.GameServiceImpl;
import game_store.services.api.UserService;
import game_store.services.impl.OrderServiceImpl;
import game_store.services.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.*;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;

@SpringBootApplication
public class ConsoleRunner implements CommandLineRunner {
    private BufferedReader br;
    private UserRepository userRepository;
    private GameRepository gameRepository;
    private OrderRepository orderRepository;
    private HashMap<String, Object> cache;
    private HashMap<String, Class> mappings;


    @Autowired
    public ConsoleRunner(UserRepository userRepository, GameRepository gameRepository, OrderRepository orderRepository) {
        this.userRepository = userRepository;
        this.gameRepository = gameRepository;
        this.orderRepository = orderRepository;
        this.getMappings();
        this.cacheRepositories();
        this.br = new BufferedReader(new InputStreamReader(System.in));

    }

    @Override
    public void run(String... strings) throws Exception {
        while (true){
            String[] input = br.readLine().split("\\|");
            String methodName = input[0].split("(?=\\p{Upper})")[0].toLowerCase();
            String controllerName = input[0].split("(?=\\p{Upper})")[1];
            String pathName = "game_store.controllers." + controllerName + "Controller";
            Object controller = this.resolveParameters(pathName);
            Method[] methods = controller.getClass().getDeclaredMethods();
            Method mtd = Arrays.stream(methods)
                    .filter(m -> m.getName().equals(methodName))
                    .findFirst()
                    .get();
            Class<?>[] mtdParams = mtd.getParameterTypes();
            Object[] methodArgs = new Object[mtd.getParameterCount()];

            for (int i = 0; i < mtdParams.length; i++) {
                if (mtdParams[i] == String.class){
                    methodArgs[i] = input[i+1];
                }else if (mtdParams[i] == BigDecimal.class){
                    methodArgs[i] = new BigDecimal(input[i+1]);
                } else if (mtdParams[i] == Date.class){
                    DateFormat format = new SimpleDateFormat("mm-DD-yyyy");
                    methodArgs[i] = format.parse(input[i+1]);
                }
            }
            System.out.println(mtd.invoke(controller, methodArgs));
        }
    }

    private Object resolveParameters(String pathName) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        if (this.cache.containsKey(pathName)){
            return this.cache.get(pathName);
        }
        Class<?> clazz = mappings.get(pathName);
        Constructor constructor = clazz.getDeclaredConstructors()[0];
        Parameter[] params = constructor.getParameters();
        Object[] arguments = new Object[constructor.getParameterCount()];

        for (int i = 0; i < params.length; i++) {
            arguments[i] = resolveParameters(params[i].getParameterizedType().getTypeName());
        }
        Object instance = constructor.newInstance(arguments);
        this.cache.put(instance.getClass().getName(), instance);
        return instance;
    }

    private void getMappings(){
        this.mappings = new HashMap<>();
        this.mappings.put(UserService.class.getName(), UserServiceImpl.class);
        this.mappings.put(UserController.class.getName(), UserController.class);
        this.mappings.put(AuthenticationContext.class.getName(),AuthenticationContext.class);
        this.mappings.put(GameService.class.getName(),GameServiceImpl.class);
        this.mappings.put(GameController.class.getName(),GameController.class);
        this.mappings.put(OrderService.class.getName(), OrderServiceImpl.class);
        this.mappings.put(ItemController.class.getName(),ItemController.class);

    }

    private void cacheRepositories(){
        this.cache = new HashMap<>();
        cache.put(UserRepository.class.getName(), this.userRepository);
        cache.put(GameRepository.class.getName(),this.gameRepository);
        cache.put(OrderRepository.class.getName(),this.orderRepository);
    }
}
