API Request for user manage activities
=====================
  |site  |
  |------|
  |MSU   |
  |STM   |
  |SUNY  |

##Get all users for ranku manager for a specific university
*Get all users From Manage For <site>

##Get all products available for university
*Get available product in ranku manage for <site>

##Get user activity logs for a university
*Get last 100 logs for <site>

##Get details of a ranku manage user
*Get user Details of <site> Ranku manage

##Get ranku manage product details with versions for a site
*Get ranku manage product details

##Get a all log for a sepcific user with user id
*Get all log for Ranku <site> manage user

##Create a new Ranku Manage User
*Create a new User in Ranku Manage for <site>

##Update a user from ranku mange user manager
\\userEditorRoles:Editor,Publisher,Viewer,No Access
\\userManagerRoles:Editor,No Access,Viewer
  |site |userEditorRole |userManagerRole|
  |-----|---------------|---------------|
  |MSU  |Publisher      |Viewer         |
  |STM  |Publisher      |Viewer         |
  |SUNY |Publisher      |Viewer         |
  |MSU  |Editor         |Editor         |
  |STM  |Editor         |Editor         |
  |SUNY |Editor         |Editor         |
*Update User <userEditorRole> and <userManagerRole> From Ranku Manage for <site>