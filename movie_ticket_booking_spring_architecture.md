# Movie Ticket Booking System — Spring Boot Package & Class Reference

Root package: `com.example.SaveMySpot`

Legend: `+` public · `-` private · `#` protected · `~` package-private · `{static}` = static member

---

## 1. `config`
Spring configuration/bean definitions. No business logic.

### `SecurityConfig`
```
+ passwordEncoder() : PasswordEncoder                {static bean}
+ securityFilterChain(http : HttpSecurity) : SecurityFilterChain
+ authenticationManager(cfg : AuthenticationConfiguration) : AuthenticationManager
```

### `JpaConfig`
```
+ auditorAware() : AuditorAware<String>              // for createdBy/updatedBy
```

### `WebConfig` (implements `WebMvcConfigurer`)
```
+ addCorsMappings(registry : CorsRegistry) : void
```

### `AppConfig`
```
+ modelMapper() : ModelMapper                        {static bean, if not using MapStruct}
```

---

## 2. `controller`
Thin — only receives HTTP requests, delegates to `service`, returns `ResponseEntity<T>`.

### `AuthController`
```
- authService : AuthService

+ register(request : RegisterRequest) : ResponseEntity<ApiResponse<UserResponse>>
+ login(request : LoginRequest) : ResponseEntity<ApiResponse<LoginResponse>>
+ refreshToken(request : RefreshTokenRequest) : ResponseEntity<ApiResponse<LoginResponse>>
+ logout(token : String) : ResponseEntity<ApiResponse<Void>>
```

### `MovieController`
```
- movieService : MovieService

+ getAllMovies() : ResponseEntity<List<MovieResponse>>
+ getMovieById(id : Long) : ResponseEntity<MovieResponse>
+ getShowsByMovie(movieId : Long, date : LocalDate) : ResponseEntity<List<ShowResponse>>
+ addMovie(request : MovieRequest) : ResponseEntity<MovieResponse>          {ADMIN only}
+ updateMovie(id : Long, request : MovieRequest) : ResponseEntity<MovieResponse>  {ADMIN only}
+ deleteMovie(id : Long) : ResponseEntity<Void>                            {ADMIN only}
```

### `BookingController`
```
- bookingService : BookingService

+ getAvailableSeats(showId : Long) : ResponseEntity<List<SeatResponse>>
+ createBooking(request : BookingRequest) : ResponseEntity<BookingResponse>
+ getBookingById(id : Long) : ResponseEntity<BookingResponse>
+ getMyBookings() : ResponseEntity<List<BookingResponse>>
+ cancelBooking(id : Long) : ResponseEntity<Void>
```

### `PaymentController`
```
- paymentService : PaymentService

+ initiatePayment(request : PaymentRequest) : ResponseEntity<PaymentResponse>
+ confirmPayment(paymentId : Long, gatewayRef : String) : ResponseEntity<PaymentResponse>
+ getPaymentStatus(paymentId : Long) : ResponseEntity<PaymentResponse>
```

### `UserController`
```
- userService : UserService

+ getProfile() : ResponseEntity<UserResponse>
+ updateProfile(request : UpdateUserRequest) : ResponseEntity<UserResponse>
+ changePassword(request : ChangePasswordRequest) : ResponseEntity<Void>
```

---

## 3. `service` (interfaces) and `service.impl` (implementations)
All business logic and transaction boundaries (`@Transactional`) live here — never in controllers or repositories.

### `AuthService` / `AuthServiceImpl`
```
+ register(request : RegisterRequest) : UserResponse
+ login(request : LoginRequest) : LoginResponse
+ refreshToken(refreshToken : String) : LoginResponse
- validateCredentials(userName : String, password : String) : boolean     {impl only}
```

### `MovieService` / `MovieServiceImpl`
```
+ getAllMovies() : List<MovieResponse>
+ getMovieById(id : Long) : MovieResponse
+ getShows(movieId : Long, date : LocalDate) : List<ShowResponse>
+ addMovie(request : MovieRequest) : MovieResponse
+ updateMovie(id : Long, request : MovieRequest) : MovieResponse
+ deleteMovie(id : Long) : void
```

### `BookingService` / `BookingServiceImpl`
```
+ getAvailableSeats(showId : Long) : List<SeatResponse>
+ createBooking(request : BookingRequest) : BookingResponse
+ getBookingById(id : Long) : BookingResponse
+ getBookingsForCurrentUser() : List<BookingResponse>
+ cancelBooking(id : Long) : void
- lockSeats(showId : Long, seatIds : List<Long>) : void                   {impl only, pessimistic lock}
- releaseSeats(bookingId : Long) : void                                   {impl only, used by scheduler}
```

### `PaymentService` / `PaymentServiceImpl`
```
- paymentGateway : PaymentGateway

+ initiatePayment(request : PaymentRequest) : PaymentResponse
+ confirmPayment(paymentId : Long, gatewayRef : String) : PaymentResponse
+ getPaymentStatus(paymentId : Long) : PaymentResponse
- handlePaymentFailure(paymentId : Long, reason : String) : void          {impl only}
```

### `UserService` / `UserServiceImpl`
```
+ getProfile(userId : Long) : UserResponse
+ updateProfile(userId : Long, request : UpdateUserRequest) : UserResponse
+ changePassword(userId : Long, request : ChangePasswordRequest) : void
```

### `NotificationService` / `EmailNotificationServiceImpl`
```
+ sendBookingConfirmation(booking : Booking) : void
+ sendCancellationNotice(booking : Booking) : void
+ sendPasswordResetLink(user : User, token : String) : void
```

---

## 4. `repository`
Spring Data JPA interfaces only — no logic, no `HashMap`.

### `UserRepository extends JpaRepository<User, Long>`
```
+ findByUserName(userName : String) : Optional<User>
+ existsByUserName(userName : String) : boolean
+ existsByEmail(email : String) : boolean
```

### `MovieRepository extends JpaRepository<Movie, Long>`
```
+ findByMovieNameContainingIgnoreCase(name : String) : List<Movie>
```

### `ShowRepository extends JpaRepository<Show, Long>`
```
+ findByMovieIdAndShowDate(movieId : Long, date : LocalDate) : List<Show>
```

### `SeatRepository extends JpaRepository<Seat, Long>`
```
+ findByShowIdAndStatus(showId : Long, status : SeatStatus) : List<Seat>
+ findByIdIn(ids : List<Long>) : List<Seat>                              {@Lock PESSIMISTIC_WRITE}
```

### `BookingRepository extends JpaRepository<Booking, Long>`
```
+ findByUserId(userId : Long) : List<Booking>
+ findByStatusAndCreatedAtBefore(status : BookingStatus, cutoff : LocalDateTime) : List<Booking>
```

### `TicketRepository extends JpaRepository<Ticket, Long>`
```
+ findByBookingId(bookingId : Long) : List<Ticket>
```

### `PaymentRepository extends JpaRepository<Payment, Long>`
```
+ findByBookingId(bookingId : Long) : Optional<Payment>
```

---

## 5. `entity` (JPA, replaces plain `model`)
All `@Entity` classes; annotated with `@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder` (Lombok) + `@Entity` + `@Table`.

### `User`
```
- id : Long                    {@Id @GeneratedValue}
- userName : String            {@Column(unique = true, nullable = false)}
- email : String               {@Column(unique = true)}
- password : String            {hashed, never exposed in DTO}
- role : Role                  {enum: USER, ADMIN}
- createdAt : LocalDateTime
```

### `Movie`
```
- id : Long
- movieName : String
- description : String
- durationMinutes : int
- genre : String
- shows : List<Show>           {@OneToMany(mappedBy = "movie")}
```

### `Show`
```
- id : Long
- movie : Movie                {@ManyToOne}
- showDate : LocalDate
- showTime : LocalTime
- theatre : String
- seats : List<Seat>           {@OneToMany(mappedBy = "show")}
```

### `Seat`
```
- id : Long
- show : Show                  {@ManyToOne}
- seatNumber : String
- status : SeatStatus           {enum: AVAILABLE, LOCKED, BOOKED}
```

### `Booking`
```
- id : Long
- user : User                  {@ManyToOne}
- show : Show                  {@ManyToOne}
- seats : List<Seat>           {@ManyToMany}
- status : BookingStatus        {enum: PENDING, CONFIRMED, CANCELLED, EXPIRED}
- bookingId : String            {UUID, from BookingIDGenerator}
- createdAt : LocalDateTime
- tickets : List<Ticket>       {@OneToMany(mappedBy = "booking")}
```

### `Ticket`
```
- id : Long
- booking : Booking            {@ManyToOne}
- seatNumber : String
- movieName : String
- showTime : LocalDateTime
```

### `Payment` (base, `@Inheritance(strategy = SINGLE_TABLE)` with `@DiscriminatorColumn`)
```
- id : Long
- booking : Booking            {@OneToOne}
- amount : BigDecimal
- status : PaymentStatus        {enum: INITIATED, SUCCESS, FAILED}
- gatewayRef : String
- paidAt : LocalDateTime
```

### `CreditCardPayment extends Payment`
```
- cardHolderName : String
- last4Digits : String          {never store full card number}
```

### `BankTransferPayment extends Payment`
```
- accountNumberMasked : String
- bankName : String
- ifscCode : String
```

### `UpiPayment extends Payment`
```
- upiId : String
```

---

## 6. `dto.request`
Plain POJOs with `javax.validation` annotations (`@NotBlank`, `@Email`, `@Size`, etc.), no JPA annotations.

```
RegisterRequest        { userName : String, email : String, password : String }
LoginRequest           { userName : String, password : String }
RefreshTokenRequest    { refreshToken : String }
MovieRequest           { movieName : String, description : String, durationMinutes : int, genre : String }
BookingRequest         { showId : Long, seatIds : List<Long> }
PaymentRequest         { bookingId : Long, method : PaymentMethod, cardDetails : CardDetailsDto (optional), upiId : String (optional) }
UpdateUserRequest      { email : String }
ChangePasswordRequest  { oldPassword : String, newPassword : String }
```

## 6b. `dto.response`
```
UserResponse      { id : Long, userName : String, email : String, role : String }
LoginResponse     { accessToken : String, refreshToken : String, tokenType : String, user : UserResponse }
MovieResponse     { id : Long, movieName : String, description : String, durationMinutes : int, genre : String }
ShowResponse      { id : Long, showDate : LocalDate, showTime : LocalTime, theatre : String, availableSeats : int }
SeatResponse      { id : Long, seatNumber : String, status : String }
BookingResponse   { id : Long, bookingId : String, status : String, seats : List<String>, tickets : List<TicketResponse> }
TicketResponse    { seatNumber : String, movieName : String, showTime : LocalDateTime }
PaymentResponse   { id : Long, status : String, amount : BigDecimal, gatewayRef : String }
ApiResponse<T>    { success : boolean, message : String, data : T, timestamp : LocalDateTime }
```

---

## 7. `mapper`
Manual or MapStruct (`@Mapper(componentModel = "spring")`) interfaces converting `entity` ↔ `dto`.

```
UserMapper    { + toResponse(user : User) : UserResponse
                + toEntity(request : RegisterRequest) : User }
MovieMapper   { + toResponse(movie : Movie) : MovieResponse
                + toEntity(request : MovieRequest) : Movie }
BookingMapper { + toResponse(booking : Booking) : BookingResponse }
TicketMapper  { + toResponse(ticket : Ticket) : TicketResponse }
```

---

## 8. `security`
```
JwtTokenProvider
  + generateAccessToken(user : User) : String
  + generateRefreshToken(user : User) : String
  + validateToken(token : String) : boolean
  + getUserNameFromToken(token : String) : String

JwtAuthenticationFilter extends OncePerRequestFilter
  # doFilterInternal(request : HttpServletRequest, response : HttpServletResponse, chain : FilterChain) : void

CustomUserDetailsService implements UserDetailsService
  + loadUserByUsername(userName : String) : UserDetails

SecurityConstants
  + JWT_EXPIRATION_MS : long              {static final}
  + REFRESH_EXPIRATION_MS : long          {static final}
```

---

## 9. `exception`
```
GlobalExceptionHandler   {@RestControllerAdvice}
  + handleUserException(ex : UserException) : ResponseEntity<ApiResponse<Void>>
  + handleResourceNotFound(ex : ResourceNotFoundException) : ResponseEntity<ApiResponse<Void>>
  + handleValidation(ex : MethodArgumentNotValidException) : ResponseEntity<ApiResponse<Map<String,String>>>
  + handleGeneric(ex : Exception) : ResponseEntity<ApiResponse<Void>>

UserException extends RuntimeException            { + UserException(message : String) }
InvalidLoginException extends UserException        { + InvalidLoginException(message : String) }
ResourceNotFoundException extends RuntimeException  { + ResourceNotFoundException(message : String) }
SeatAlreadyBookedException extends RuntimeException { + SeatAlreadyBookedException(message : String) }
PaymentFailedException extends RuntimeException     { + PaymentFailedException(message : String) }
```

---

## 10. `payment` (gateway integration — real processing, separate from the `entity` data holders)
```
PaymentGateway (interface)
  + charge(amount : BigDecimal, method : PaymentMethod, details : Map<String,String>) : GatewayResult

RazorpayGatewayImpl implements PaymentGateway
  + charge(amount : BigDecimal, method : PaymentMethod, details : Map<String,String>) : GatewayResult

GatewayResult { success : boolean, referenceId : String, failureReason : String }
```

---

## 11. `scheduler`
```
BookingExpiryScheduler
  + expireUnpaidBookings() : void         {@Scheduled(fixedRate = 60000)}
```

---

## 12. `util`
```
BookingIdGenerator
  + generate() : String {static}          // UUID-based booking reference

DateTimeUtils
  + isPast(date : LocalDate, time : LocalTime) : boolean {static}
```

## 13. `constants`
```
AppConstants     { + DEFAULT_SEAT_LOCK_MINUTES : int {static final} }
ErrorMessages    { + USER_NOT_FOUND : String {static final}, + SEAT_ALREADY_BOOKED : String {static final}, ... }
```

---

## 14. Root
```
MovieTicketBookingSystemApplication
  + main(args : String[]) : void {static}     {@SpringBootApplication}
```

---

## Key relationships to model in your UML

| Relationship | Type | Example |
|---|---|---|
| Controller → Service | Association (DI, `final` field) | `BookingController → BookingService` |
| Service → Repository | Association (DI) | `BookingServiceImpl → BookingRepository, SeatRepository` |
| Service → Mapper | Dependency | `MovieServiceImpl ⇢ MovieMapper` |
| Repository → Entity | Association (generic parameter) | `UserRepository<User, Long>` |
| Payment ← subclasses | Inheritance | `CreditCardPayment/BankTransferPayment/UpiPayment → Payment` |
| UserException ← subclasses | Inheritance | `InvalidLoginException → UserException → RuntimeException` |
| Booking *— Ticket | Composition (tickets die with booking) | `Booking *-- Ticket` |
| Show *— Seat | Composition | `Show *-- Seat` |
| Booking o— Seat | Aggregation (seats outlive a cancelled booking) | `Booking o-- Seat` |
| JwtAuthenticationFilter ⇢ JwtTokenProvider | Dependency | filter calls token provider per request |
| GlobalExceptionHandler ⇢ all custom exceptions | Dependency | catches, doesn't own |

---

## What changed vs. your original prototype
- `model` → split into `entity` (JPA, DB-backed) and `dto` (API contracts) — never expose entities directly over REST
- `repository` → real Spring Data interfaces, no more `HashMap` fake data
- New `service` layer sits between `controller` and `repository` — this was completely missing before
- `util.PasswordHashing` / `VerifyPassword` → replaced by a single `PasswordEncoder` bean in `SecurityConfig`, injected wherever needed
- `validation` package (manual `authenticateUser`) → replaced by Bean Validation annotations on DTOs + `AuthService.login()`
- Added `security`, `config`, `mapper`, `exception` (global), `payment` (gateway), `scheduler`, `notification`, `constants` — all absent in the prototype
