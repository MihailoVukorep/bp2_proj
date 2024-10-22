# Military Database Management System
### Mihailo Vukorep IN 40/2021

## Description:
System will serve for military management purposes.

The motivation and goal is to keep track of personnel, equipment, vehicles and missions across multiple bases.

## Entites & Relationships 

### Relationships

- **Military Member** has **one or more Specialties**. **Specialty** can belong to 0 or N members.
- **Military Member** has **one Rank**. **Rank** can belong to 0 or N members.
- **Military Member** has 0 or 1 supervisor (recursive relationship with another member).
- **Military Member** can manage one or more **Missions**. Each **Mission** is managed by one **Military Member** (must be sergeant or higher rank).
- **Military Base** IS-A **Personnel facility** or **Storage facility**.
- **Military Member** belongs to 0 or 1 **Military Base (Personnel facility)**. **Military Base (Personnel facility)** has 0 or N **Military Members**.
- **Military Base** is located in **one Location**. **One Location** can have 0 or N **Military Bases**.
- One or more **Military Members** can participate in a **Mission**.
- **Vehicle** is assigned to **one Military Base (Storage facility)**. **Military Base (Storage facility)** can have multiple **Vehicles**.
- **Equipment** originates from **one Military Base (Storage facility)**. **Military Base (Storage facility)** can have multiple **Equipment**.
- **Military Member** can use 0 or N **Equipment**, **Equipment** can be used by 0 or 1 **Military Member**.
- **Military Member** can use 0 or 1 **Vehicle**, **Vehicle** can be used by 0 or 1 **Military Member**.

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
    - `equipment_type_id` (references **Equipment Type**)
    - `status` (functional, broken)
    - `base_id` (references **Military Base (Storage facility)**)

7. **Equipment Type**
    - `equipment_type_id`
    - `type` (e.g., weapon, communication device, uniform, etc.)

8. **Vehicle**  
    - `vehicle_id`
    - `vehicle_type_id` (references **Vehicle Type**)
    - `base_id` (references **Military Base (Storage facility)**)

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


---

1. **Command Assignment** (Gerund)
    - `command_assignment_id`
    - `soldier_id`
    - `base_id`
    - `start_date`
    - `end_date`

2. **Member Specialty** (Gerund)
    - `member_specialty_id`
    - `soldier_id`
    - `specialty_id`

3. **Equipment Stored At** (Gerund)
    - `equipment_assignment_id`
    - `equipment_id` (references **Equipment**)
    - `base_id` (references **Military Base (Storage facility)**)
    - `assigned_date`

4. **Vehicle Stored At** (Gerund)
    - `vehicle_assignment_id`
    - `vehicle_id` (references **Vehicle**)
    - `base_id` (references **Military Base (Storage facility)**)
    - `assigned_date`

5. **Reporting Hierarchy** (Recursion)
    - `reporting_hierarchy_id`
    - `soldier_id`
    - `supervisor_id`

6. **Mission Member** (Gerund)
    - `mission_member_id`
    - `mission_id` (references **Mission**)
    - `soldier_id` (references **Military Member**)

7. **Equipment Using** (Gerund)
    - `equipment_using_id`
    - `equipment_id` (references **Equipment**)
    - `soldier_id` (references **Military Member**)
    - `status` (using, repairing)
    - `start_date`
    - `end_date`

8. **Vehicle Using** (Gerund)
    - `vehicle_using_id`
    - `vehicle_id` (references **Vehicle**)
    - `soldier_id` (references **Military Member**)
    - `status` (using, repairing)
    - `start_date`
    - `end_date`
