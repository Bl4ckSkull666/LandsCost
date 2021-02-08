# LandsCost
This is a third Party plugin for the [Lands plugin](https://www.spigotmc.org/resources/lands-land-claim-plugin-grief-prevention-protection-gui-management-nations-wars-1-16-support.53313/) 

Allow the users land creation and claim to pay with items. 

Its use the language of the user, is that not translated, it use the default-language from config.yml. Is this file not exist, it set a random exist file as default language.


Example for Player locale, changed from German to English ( United Kingdom ):
![Locale by Player](https://github.com/Bl4ckSkull666/LandsCost/blob/master/screens/client_locale.png?raw=true)


### parameters for locale files:
> %land% => Current created land count // only in land locales  
> %claim% => Current claimed chunk count // only in claim locales  
> %item% => The Material of the Item that the land/claim cost.  
> %itemname% => The Itemname from locale file for the material  
> %amount% => Amount of Items that it cost.  

### config.yml
```yaml
default-language: 'en-GB'
cost:
    create:
        material: emerald
        amount: 1
        multipli: 1
    claim:
        material: iron_ingot
        amount: 5
        multipli: 0.25 
```  
  
#### Formular of Multipli(cate):
amount*(1.0+(multipli*count)) = Result will be round to the next full integer.  
amount = Amount from config.yml  
multipli = Multipli from config.yml  
count = The count of Lands/Claims by Player  
