/*OrganizerRepository.java
Organizer Repository Class
Author: Oratile Precious Phologane (230690939)
Date:19 March 2025
 */

package za.ac.cput.Repository;

import za.ac.cput.Domain.Organizer;
import java.util.List;
import java.util.ArrayList;

public class OrganizerRepository implements IOrganizerRepository{
    private static IOrganizerRepository repository = null;
    private final List<Organizer> organizersList;

    //List to store Organizer Objects
    private OrganizerRepository(){
        organizersList = new ArrayList<Organizer>();
    }

    //Singleton implementation
    public static IOrganizerRepository getRepository(){
        if(repository == null){
            repository = new OrganizerRepository();
        }
        return repository;

    }

    @Override
    public List<Organizer> getAllOrganizers(){
        return new ArrayList<>(organizersList);

    }

    //Creates a new organizer and adds it the list
    @Override
    public Organizer create(Organizer organizer){
        if (organizer != null && !organizersList.contains(organizer)) {
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

    //Update organizer's details
    @Override
    public Organizer update(Organizer updatedOrganizer){
        Organizer retrievedOrganizer = read(updatedOrganizer.getOrganizerId());
            if(retrievedOrganizer != null){
                organizersList.set(organizersList.indexOf(retrievedOrganizer), updatedOrganizer);
                return updatedOrganizer;
            }

        System.out.println("Organizer not found" + updatedOrganizer.getOrganizerId());
        return null;
    }

    //Delete an organizer
    @Override
    public boolean delete(String organizerId){
        for(Organizer organizer : organizersList){
            if(organizer.getOrganizerId().equals(organizerId)){
                organizersList.remove(organizer);
                return true;
            }
        }
        return false;
    }
    //Clears the repository to reset data between test runs
    public void clear(){
        organizersList.clear();
    }

}
