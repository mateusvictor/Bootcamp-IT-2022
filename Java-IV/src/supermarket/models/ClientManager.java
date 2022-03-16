package supermarket.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ClientManager implements CRUD<Client> {
    private static ClientManager clientManager = new ClientManager();
    private HashMap<Integer, Client> clients = new HashMap<Integer, Client>();
    private Integer lastId = 0;

    public static ClientManager getInstance() {
        return clientManager;
    }

    public ClientManager() {
    }

    @Override
    public Client create(Client client) {
        client.setId(lastId + 1);
        clients.put(lastId+1, client);
        lastId += 1;
        return client;
    }

    @Override
    public List<Client> readAll() {
        ArrayList<Client> clientsList = new ArrayList<Client>();
        for (Integer key : clients.keySet())
            clientsList.add(clients.get(key));
        return clientsList;
    }

    @Override
    public Client read(Integer id) {
        if (clients.containsKey(id))
            return clients.get(id);
        return null;

    }

    @Override
    public void delete(Integer id) {
        if (clients.containsKey(id)) {
            clients.remove(id);
            System.out.println("Cliente ID: " + id + " deletado.");
        }
        else
            System.out.println("Nao foi encontrado cliente com o ID especificado.");
    }
}
