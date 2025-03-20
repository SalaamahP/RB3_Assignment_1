/*OrganizerRepository.java
Organizer Repository Class
Author: Oratile Precious Phologane (230690939)
Date:19 March 2025
 */

package za.ac.cput.Repository;

import za.ac.cput.Entity.Organizer;
import java.util.List;
import java.util.ArrayList;

public class OrganizerRepository implements IOrganizerRepository{
    private static IOrganizerRepository repository = null;
    private final List<Organizer> organizersList;

    private OrganizerRepository(){
        organizersList = new ArrayList<Organizer>();
    }

    public static IOrganizerRepository getRepository(){
        if(repository == null){
            repository = new OrganizerRepository();
        }
        return repository;

    }

    @Override
    public List<Organizer> getAllOrganizers(){
        return List.of();

    }

    @Override
    public Organizer create(Organizer organizer){
        if (organizer != null) {
            organizersList.add(organizer);
            return organizer;
        }
        return null;
    }

    @Override
    public Organizer read(String organizerId){
        for (Organizer organizer : organizersList) {
            if (organizer.getOrganizerId().equals(organizerId)) {
                return organizer;
            }
        }
        return null;
    }

    @Override
    public Organizer update(Organizer updatedOrganizer){
        for(int i=0; i<organizersList.size(); i++){
            if(organizersList.get(i).getOrganizerId().equals(updatedOrganizer.getOrganizerId())){
                organizersList.set(i, updatedOrganizer);
                return updatedOrganizer;
            }
        }
        return null;
    }

    @Override
    public boolean delete(String organizerId){
        for(int i=0; i<organizersList.size(); i++){
            if(organizersList.get(i).getOrganizerId().equals(organizerId)){
                organizersList.remove(i);
                return true;
            }
        }
        return false;
    }

}
