# Military Database Management System
### Mihailo Vukorep IN 40/2021

## Description:
System will serve for military management purposes.

The motivation and goal is to keep track of personnel, equipment, vehicles and missions across multiple bases. Recording the dates in some entities will ensure we perserve useful historical data.

## Entites & Relationships 

### Relationships
- **Military Member** has 1 or N **Specialties**. **Specialty** can belong to 0 or N members.
- **Military Member** has 1 **Rank**. **Rank** can belong to 0 or N members.
- **Military Member** has 0 or 1 supervisor (recursive relationship with another member).
- **Military Member** (must be sergeant or higher rank) can manage 0 or N **Missions**. Each **Mission** is managed by 1 **Military Member** (must be sergeant or higher rank).
- **Mission** is located in 1 **Location**. **Location** can have 0 or N **Missions**.
- **Military Base** IS-A **Personnel facility** or **Storage facility**.
- **Military Member** belongs to 0 or 1 **Military Base (Personnel facility)**. **Military Base (Personnel facility)** has 0 or N **Military Members**.
- **Military Base** is located in 1 **Location**. **Location** can have 0 or N **Military Bases**.
- **Military Member** can participate in only 1 **Mission** at a time but can be in multiple when they end, **Mission** can have 1 or N **Military Members**.
- **Vehicle** is assigned to 0 or 1 **Military Base (Storage facility)**. **Military Base (Storage facility)** can have 0 or N **Vehicles**.
- **Equipment** originates from 0 or 1 **Military Base (Storage facility)**. **Military Base (Storage facility)** can have multiple **Equipment**.
- **Military Member** owns 0 or N **Equipment**, **Equipment** is owned by 0 or 1 **Military Member**.
- **Military Member** drives 0 or 1 **Vehicle**, **Vehicle** is driven by 0 or 1 **Military Member**.
- **Mission Participation** (Military Member+Mission) can be awarded 0 or 1 **Service Medals**. **Mission Participation** can have 0 or 1 **Service Medals**.
- **Vehicle** is one Type.
- **Equipment** is one Type.
- **Service Medal** is one Type.

### Entities
1. **Military Member**
    - `soldier_id` (unique member identifier)
    - `first_name`
    - `last_name`
    - `rank_id` (references **Rank**)
    - `date_of_joining`
    - `base_id` (references **Military Base (Personnel facility)**) - might be null

2. **Rank**
    - `rank_id` (unique identifier)
    - `name` (e.g., soldier, sergeant, captain)
    - `description` (optional)

3. **Specialty**
    - `specialty_id` (unique identifier)
    - `name` (e.g., pilot, tank operator, medic, mechanic, ...)
    - `description` (optional)

4. **Military Base**
    - `base_id` (unique identifier)
    - `name`
    - `type` (**Personnel facility** or **Storage facility**)
    - `location_id` (references **Location**)

5. **Location**
    - `location_id`
    - `country`
    - `city`

6. **Equipment**
    - `equipment_id`
    - `current_owner_id` (references **Military Member**) - might be null
    - `equipment_type_id` (references **Equipment Type**)
    - `status` (functional, broken)
    - `from_base_id` (references **Military Base (Storage facility)**) - might be null

7. **Equipment Type**
    - `equipment_type_id`
    - `type` (e.g., weapon, communication device, uniform, etc.)

8. **Vehicle**  
    - `vehicle_id`
    - `current_driver_id` (references **Military Member**) - might be null
    - `vehicle_type_id` (references **Vehicle Type**)
    - `from_base_id` (references **Military Base (Storage facility)**) - might be null

9. **Vehicle Type**
    - `vehicle_type_id`
    - `model_name`
    - `name` (e.g., aircraft, tank, helicopter, transporter, etc.)

10. **Mission**
    - `mission_id`
    - `name`
    - `description` (mission objective)  
    - `start_date`
    - `end_date`
    - `status` (planned, active, completed, cancelled)
    - `commander_id` (references **Military Member**) ; Only Rank allowed: Sergeant or higher
    - `location_id` (references **Location**)

11. **Service Medal** (Weak Entity)
    - `mission_participation_id` (references **Mission Participation**)
    - `award_date`
    - `service_medal_type_id` (references **Service Medal Type**)
    - `description` (why the medal was awarded)

12. **Service Medal Type**
    - `service_medal_type_id`
    - `name`

---

1. **Member Specialty**
    - `member_specialty_id`
    - `soldier_id`
    - `specialty_id`

2. **Reporting Hierarchy**
    - `reporting_hierarchy_id`
    - `soldier_id`
    - `supervisor_id`

3. **Mission Participation**
    - `mission_participation_id`
    - `soldier_id` (references **Military Member**)
    - `mission_id` (references **Mission**)
