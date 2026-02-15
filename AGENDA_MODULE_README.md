# Module Agenda - Documentation

## Vue d'ensemble

Ce module agenda offre une interface complète plein écran permettant à l'utilisateur de visualiser et gérer des événements dans un calendrier.

## Architecture

### Fichiers créés

1. **Models**
   - `Event.java` : Modèle de données représentant un événement (titre, description, date, heure)

2. **Activities**
   - `AgendaActivity.java` : Activité principale gérant la logique du calendrier et l'affichage des événements
   - `AddEventActivity.java` : Activité de formulaire pour ajouter de nouveaux événements

3. **Adapters**
   - `EventAdapter.java` : Adaptateur RecyclerView pour afficher la liste des événements d'une date

4. **Layouts**
   - `activity_agenda.xml` : Layout principal avec CalendarView, card des détails, RecyclerView et FAB
   - `activity_add_event.xml` : Layout du formulaire d'ajout d'événement
   - `item_event.xml` : Layout d'un item événement dans la liste

5. **Resources**
   - Nouvelles couleurs ajoutées dans `colors.xml`
   - Nouveaux strings ajoutés dans `strings.xml`
   - Nouveaux styles pour le calendrier dans `styles.xml`

## Fonctionnalités implémentées

### 1. Calendrier plein écran
- CalendarView Material Design occupant la majeure partie de l'écran
- Navigation intuitive entre les mois et années

### 2. Indicateurs visuels
- Structure de données prête pour afficher des indicateurs sous les dates contenant des événements
- Les jours sans événement n'ont aucun indicateur
- La couleur des indicateurs est définie par `@color/accent` (rose)

### 3. Affichage des événements
- Sélection d'une date pour voir ses événements
- Card Material qui s'affiche uniquement si la date contient des événements
- Liste des événements avec heure, titre et description
- Indicateur de couleur sur le côté gauche de chaque événement

### 4. Ajout d'événements
- Bouton d'action flottant (FAB) positionné en bas à droite
- Formulaire complet pour ajouter des événements avec :
  - Titre (obligatoire)
  - Description (optionnelle)
  - Sélecteur de date avec DatePickerDialog
  - Sélecteur d'heure avec TimePickerDialog
- Validation du formulaire
- Retour des données à l'activité principale
- Mise à jour automatique de l'affichage après ajout

### 5. Gestion des données
- Stockage en mémoire avec HashMap pour accès rapide
- Données simulées pour démonstration
- Support pour ajout d'événements en temps réel

## Données simulées

L'activité contient des événements simulés pour démonstration :
- 15 février 2026 : 2 événements (Réunion d'équipe, Présentation client)
- 18 février 2026 : 1 événement (Formation Java)
- 20 février 2026 : 1 événement (Revue de code)
- 22 février 2026 : 1 événement (Déjeuner d'équipe)
- 25 février 2026 : 1 événement (Atelier design)
- 1er mars 2026 : 1 événement (Conférence tech)

## Utilisation

### Lancer l'activité

```java
Intent intent = new Intent(context, AgendaActivity.class);
startActivity(intent);
```

### Ajouter un événement via l'interface

1. Ouvrir l'AgendaActivity
2. Cliquer sur le bouton FAB (bouton rose flottant en bas à droite)
3. Remplir le formulaire :
   - Titre (obligatoire)
   - Description (optionnel)
   - Date (via le sélecteur de date)
   - Heure (via le sélecteur d'heure)
4. Cliquer sur "Enregistrer"
5. L'événement s'ajoute automatiquement à la date sélectionnée

### Ajouter un événement programmatiquement

```java
Calendar cal = Calendar.getInstance();
cal.set(2026, Calendar.FEBRUARY, 28);
Event event = new Event("Titre", "Description", cal, "14:00");
addEventToMap(event);
```

## Personnalisation

### Modifier les couleurs

Dans `colors.xml` :
- `primary` : Couleur principale (toolbar, textes d'accentuation)
- `accent` : Couleur des indicateurs sous les dates
- `text_secondary` : Couleur des textes secondaires

### Modifier l'apparence du calendrier

Dans `styles.xml` :
- `CalendarDateTextAppearance` : Style des dates
- `CalendarWeekDayTextAppearance` : Style des jours de la semaine

## Points techniques

### Gestion des indicateurs
L'implémentation utilise un `CustomIndicatorView` (Drawable personnalisé) qui se superpose au CalendarView via un `View` overlay. Cette approche permet de dessiner des indicateurs visuels sans modifier le CalendarView natif.

### Structure de données
Les événements sont stockés dans une `HashMap<String, List<Event>>` où la clé est au format "année-mois-jour" pour un accès rapide.

### RecyclerView
L'affichage des événements utilise un RecyclerView avec un adaptateur personnalisé, permettant une liste fluide et performante même avec de nombreux événements.

## Évolutions futures possibles

1. ~~Implémenter un vrai formulaire d'ajout d'événements (via le FAB)~~ ✅ **FAIT**
2. Ajouter la persistance des données (Base de données Room ou SharedPreferences)
3. Implémenter la modification et suppression d'événements
4. Ajouter des notifications/rappels
5. Synchronisation avec Google Calendar
6. Vue liste/semaine en plus de la vue mois
7. Filtres par type d'événement
8. Export/Import d'événements
9. Implémenter les indicateurs visuels sous les dates du calendrier (dots)

## Design

Le design suit les principes Material Design avec :
- Une approche épurée et moderne
- Des cartes (Cards) pour structurer le contenu
- Un FAB pour l'action principale
- Des couleurs cohérentes et une hiérarchie visuelle claire
- Une typographie lisible avec différents poids de police
