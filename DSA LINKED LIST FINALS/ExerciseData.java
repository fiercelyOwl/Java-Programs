public class ExerciseData {
    private ExerciseList exercises;
    public ExerciseData(ExerciseList exercises) {
        this.exercises = exercises;
        addSampleExercises(); 
    }

    private void addSampleExercises() {
        final String PLACEHOLDER_LINK = "https://www.youtube.com/watch?v=placeholder";
            
// 1. Neck Pain
        exercises.addExercise("Neck Stretch", "Neck Pain", 
            "This exercise gently stretches the side muscles of your neck. It is highly effective in relieving daily muscle stiffness and tension.", 
            "Sit up straight. Slowly tilt your head to the left, holding for 10 counts/seconds. Repeat the tilt to the right side, holding for 10 counts/seconds.", 
            "Perform 5 sets", 
            "<ul><li>Reduces chronic neck tension and stiffness.</li><li>Significantly improves neck flexibility and range of motion.</li><li>Can help prevent tension headaches caused by tight neck muscles.</li></ul>", 
            "https://youtu.be/ekLJMzJWZU4?si=xNtj6kCNDN1f-vyk");
            
        exercises.addExercise("Shoulder Shrugs", "Neck Pain", 
            "Shoulder shrugs are a simple, low-impact movement that targets the upper trapezius muscle. This helps in loosening tight muscles that run from the shoulders up to the neck.", 
            "Lift your shoulders straight up toward your ears, hold this tight position for 5 counts/seconds.", 
            "Perform 10 repetitions", 
            "<ul><li>Relieves tension specifically in the upper back and neck region.</li><li>Increases blood circulation to the shoulder and neck muscles.</li><li>Aids in reducing muscular fatigue from prolonged sitting.</li></ul>", 
            "https://youtu.be/ja_P3YhmAlE?si=Ru2D8P7-l19Dvj71");
            
        exercises.addExercise("Chin Tucks", "Neck Pain", 
            "This is a key exercise for correcting 'forward head posture,' often associated with using computers or phones. It works by strengthening the deep neck flexor muscles at the front of your neck.", 
            "Gently pull your chin straight back toward your throat without tilting your head up or down, holding the deep tuck for 5 counts/seconds.", 
            "Perform 10 repetitions", 
            "<ul><li>Strengthens deep neck muscles for better spinal stability.</li><li>Significantly improves overall cervical posture by pulling the head back over the shoulders.</li><li>Helps in the long-term reduction of chronic neck pain.</li></ul>", 
            "https://youtu.be/u8C5LgpK3r4?si=LmGXhjQLwD5-XwnS");

// 2. Shoulder Pain
        exercises.addExercise("Arm Raise", "Shoulder Pain", 
            "The arm raise is a basic range-of-motion exercise that helps to keep the shoulder joint loose and functional. It is performed slowly to avoid any sudden jarring of the painful joint.", 
            "Start with arms down by your sides. Slowly lift your arms straight out in front of you until they are overhead (or as high as comfortable), then slowly lower them back down.", 
            "Perform 10 repetitions", 
            "<ul><li>Works to safely improve shoulder mobility and range of motion.</li><li>Increases circulation to the muscles and ligaments around the shoulder.</li><li>Helps prevent the onset of stiffness(e.g., frozen shoulder).</li></ul>", 
            "https://youtu.be/Bqvmyni_sKQ?si=WLWb4Ljqp2swkV_e");
            
        exercises.addExercise("Shoulder Circles", "Shoulder Pain", 
            "This is a dynamic stretch that gently warms up and activates the rotator cuff and surrounding shoulder muscles. It is essential for loosening any tightness built up in the upper body.", 
            "Rotate your shoulders in small, smooth circles forward for 10 complete counts, then reverse direction and rotate them backward.", 
            "Perform 10 counts in each direction",
            "<ul><li>Effectively reduces stiffness in the shoulder girdle.</li><li>Promotes a greater and smoother range of movement.</li><li>Serves as an excellent warm-up before performing more intense shoulder exercises.</li></ul>", 
            "https://youtu.be/jDbfuzfdVHM?si=jgbn-nENPbsjIJ5L");
			
		exercises.addExercise("Shoulder Squeezes", "Shoulder Pain", 
            "Scapular (shoulder blade) strength is vital for good posture, which takes stress off the shoulder joint. This exercise strengthens the middle back muscles.", 
            "Sit or stand tall. Keeping your arms relaxed at your sides, squeeze your shoulder blades together as if trying to hold a pencil between them. Do not shrug your shoulders.", 
            "Hold the squeeze for 5 counts/seconds. Perform 10 to 12 repetitions.", 
            "<ul><li>Strengthens the muscles responsible for good upper back posture.</li><li>Takes strain off the front of the shoulder and neck.</li><li>Prevents rounding of the shoulders, which can lead to pain.</li></ul>", 
            "https://youtu.be/ouRhQE2iOI8?si=gf8bx06HBBrMZDhf");
			
		exercises.addExercise("Internal/External Rotation", "Shoulder Pain", 
            "This exercise strengthens the small, critical rotator cuff muscles. It is essential for stabilizing the shoulder joint and is often done with a light band or small weight.", 
            "Stand with your elbow bent 90 degrees and tucked close to your side. Slowly rotate your forearm inward toward your stomach (internal) and then outward away from your body (external).", 
            "Perform 10 slow, controlled repetitions in both directions per arm.", 
            "<ul><li>Directly strengthens the rotator cuff muscles for stability.</li><li>Reduces pain caused by shoulder instability or impingement.</li><li>Improves function for reaching and pulling movements.</li></ul>", 
            "https://youtube.com/shorts/-o2EADkGS3M?si=cuHuP07v5hwbuKtw");

// 3. Back Pain
        exercises.addExercise("Cat-Cow Stretch", "Back Pain", 
            "The Cat-Cow is a foundational yoga pose that gently stretches and mobilizes the entire spine from the tailbone to the neck. This movement lubricates the spinal discs and is excellent for warming up the back.", 
            "Start on your hands and knees. Slowly arch your back upward (Cat Pose) while tucking your chin, then slowly move to the opposite position by dropping your stomach and lifting your head (Cow Pose).", 
            "Perform 10 full cycles", 
            "<ul><li>Reduces chronic back tension and pressure on spinal nerves.</li><li>Dramatically improves overall spine flexibility and mobility.</li><li>Strengthens abdominal muscles which support the lower back.</li></ul>", 
            "https://youtu.be/vuyUwtHl694?si=j2R_qcjhaVJK4Ebm");
            
        exercises.addExercise("Lower Back Stretch", "Back Pain", 
            "This stretch is performed lying down and is highly effective at releasing tight muscles in the lumbar region (lower back). It gently decompresses the spine and is often recommended for immediate pain relief.", 
            "Lie on your back and slowly pull both knees toward your chest, holding the stretch tightly for 10 counts/seconds.", 
            "Perform 5 full repetitions", 
            "<ul><li>Provides immediate and effective relief for lower back pain.</li><li>Gently stretches the gluteal muscles which connect to the lower back.</li><li>A good exercise for releasing tension before sleep.</li></ul>", 
            "https://youtu.be/sgO7BK6fxK4?si=kABZua3mLePh3iom");
			
		exercises.addExercise("Pelvic Tilt", "Back Pain", 
            "A foundational core exercise done on the floor that gently strengthens the lower abdominal muscles and teaches control of the lower back (lumbar spine).", 
            "Lie on your back with knees bent and feet flat. Flatten your lower back against the floor by tightening your abdominal and gluteal muscles. You should feel your tailbone rock slightly up.", 
            "Hold the tilt for 5 counts/seconds. Perform 10 to 12 repetitions.", 
            "<ul><li>Strengthens the deep core muscles that support the lower back.</li><li>Teaches controlled movement of the lumbar spine.</li><li>Helps relieve muscle spasms and stiffness in the low back.</li></ul>", 
            "https://youtu.be/ZIQjHtghzqw?si=D_27nbvnHpQJoJb_");
			
		exercises.addExercise("Supine Spinal Twist", "Back Pain", 
            "This stretch gently rotates the spine and hips, which can release tension in the lower back and upper buttock area (piriformis/glutes).", 
            "Lie on your back with arms out to the side. Keep both knees together and slowly lower them to one side, twisting your lower back. Look in the opposite direction of your knees.", 
            "Hold the stretch for 30 seconds. Repeat on the opposite side.", 
            "<ul><li>Gently mobilizes the lumbar and thoracic (mid) spine.</li><li>Stretches the muscles around the hip and buttock.</li><li>Effective at relieving general tightness from sitting or standing too long.</li></ul>", 
            "https://youtu.be/mNdJti7ZwKI?si=EFraX38a4NEysMq4");

// 4. Leg Pain
        exercises.addExercise("Leg Stretch", "Leg Pain", 
            "This stretch specifically targets the hamstrings, which are the large muscles running down the back of the thighs. Tight hamstrings are a common cause of pain that can radiate down the leg.", 
            "Sit on the floor with legs straight and reach toward your toes, holding the deepest point of the stretch for 15 counts/seconds.", 
            "Perform 3 repetitions, holding for 15 counts/seconds", 
            "<ul><li>Dramatically enhances the flexibility of the hamstrings.</li><li>Improves overall blood circulation throughout the entire leg.</li><li>Reduces the risk of muscle strain during physical activity.</li></ul>", 
            "https://youtu.be/tGmDP2CO52Y?si=fdJFBNS_uJ7f5fTX");
            
        exercises.addExercise("Heel Raises", "Leg Pain", 
            "Heel raises are a primary way to strengthen the calf muscles (gastrocnemius and soleus) in the lower leg. Strong calf muscles help support your weight and reduce strain on other leg joints.", 
            "Stand while holding onto a chair for balance. Slowly lift your heels as high as possible, standing on the balls of your feet, then slowly lower.", 
            "Perform 15 slow, controlled repetitions", 
            "<ul><li>Strengthens the calf muscles in the lower legs.</li><li>Significant help in improving overall balance and stability.</li><li>Increases the strength needed for walking and running.</li></ul>", 
            "https://youtu.be/dV4Yjv-gsyY?si=Yd29ROn1cQ4Y3nr5");
            
        exercises.addExercise("Quad Stretch", "Leg Pain", 
            "The Quadriceps Femoris is a group of four large muscles on the front of the thigh, which can become extremely tight from sitting. This standing stretch helps to restore their full length and mobility.", 
            "Stand and hold onto a wall or chair. Pull one foot toward your buttocks until you feel a gentle stretch in the front of the thigh, holding for 15 counts/seconds. Switch to the other leg and repeat.", 
            "Perform 2 holds per leg", 
            "<ul><li>Effectively reduces tightness and soreness in the front thigh muscles.</li><li>Increases hip and knee mobility for better movement.</li><li>Helps in the prevention of knee tracking issues often caused by tight quads.</li></ul>", 
            "https://youtu.be/DxBDqHL5NlM?si=GUuzZvRDvh7blUhw");

// 5. Wrist / Hand Pain
        exercises.addExercise("Wrist Flex and Stretch", "Hand Pain", 
            "This compound movement stretches both the flexor and extensor muscles of the forearm, which are connected to the hand and wrist. It is crucial for maintaining tendon health and preventing conditions like Carpal Tunnel Syndrome.", 
            "Extend one arm straight out with the palm up, then gently pull your fingers down towards your body using the opposite hand, holding the stretch for 10 counts/seconds.", 
            "Perform 5 repetitions per arm", 
            "<ul><li>Reduces stiffness and chronic pain in the wrist joint.</li><li>Improves overall flexibility of the forearm and hand tendons.</li><li>Increases circulation, aiding in the recovery from repetitive strain injuries.</li></ul>", 
            "https://youtu.be/_uINTR_7X-g?si=l3wdben55fC_3cJf");
            
        exercises.addExercise("Fist Clench", "Hand Pain", 
            "Fist clenches are a simple but effective isometric exercise designed to strengthen the many small muscles within the hand. This can be done almost anywhere and requires no equipment.", 
            "Make a tight fist, squeeze it gently but firmly, and hold the clench for 5 counts/seconds. Slowly open your hand and repeat the clench.", 
            "Perform 10 complete repetitions", 
            "<ul><li>Significantly increases grip strength, which is vital for daily tasks.</li><li>Helps reduce tension and swelling that can build up in the fingers and hand.</li><li>Maintains dexterity and coordination in the hand and fingers.</li></ul>", 
            "https://youtube.com/shorts/JRZz1yrBtSk?si=ltCsGuI6CY89W40G");
            
// 6. Knee Pain
        exercises.addExercise("Knee Marching", "Knee Pain", 
            "This is a very low-impact exercise intended to gently warm up the knee and hip joints without placing stress on the cartilage. It helps improve synovial fluid circulation, which lubricates the joint.", 
            "Sit or stand tall. Gently lift one knee up toward your chest, then alternate with the other knee, maintaining a rhythmic marching motion.", 
            "Perform 15 complete steps per leg", 
            "<ul><li>Improves knee mobility and fluid circulation in the joint.</li><li>Effectively reduces stiffness before more intensive activity.</li><li>A safe, low-impact exercise suitable for almost all mobility levels.</li></ul>", 
            "https://youtu.be/-aQbL65YHR0?si=ykn1MUQOBjwQd66X");
            
        exercises.addExercise("Straight Leg Raise", "Knee Pain", 
            "This exercise focuses on strengthening the quadriceps (thigh muscles) without bending the knee, which is often painful in injured or arthritic joints. Strong quads provide essential support and stability to the knee cap and joint.", 
            "Sit on the floor with your legs straight. Tighten your thigh muscle (quadriceps) and slightly lift one leg off the floor, holding for 5 counts/seconds and lower it slowly.", 
            "Perform 10 repetitions per leg", 
            "<ul><li>Strengthens the quadriceps for superior knee support.</li><li>Helps reduce chronic knee pain by increasing joint stability.</li><li>It is a non-weight bearing exercise, minimizing stress on the joint.</li></ul>", 
            "https://youtu.be/Ka19yzAlIGY?si=nnj8RgyWguexPQte");
			
		exercises.addExercise("Single-Leg Balance", "Knee Pain", 
            "This exercise builds proprioception (joint awareness) and drastically improves the stability of the entire leg chain, especially the supportive muscles around the knee and hip.", 
            "Stand near a sturdy surface (like a counter) for safety. Lift one foot slightly off the floor and try to maintain balance on the other leg without wobbling.", 
            "Hold the balance for 30 seconds per leg. Repeat 3 times.", 
            "<ul><li>Significantly improves joint awareness and stability (proprioception).</li><li>Strengthens the ankle, knee, and hip stabilizers simultaneously.</li><li>Crucial for preventing falls and instability caused by knee pain.</li></ul>", 
            "https://youtu.be/Dtgh2_LFkBQ?si=orQ5qOiQ8h3_bZyQ");
			
		exercises.addExercise("Standing Calf Stretch", "Knee Pain", 
            "Tight calf muscles often pull on the Achilles tendon and restrict ankle movement, which forces the knee to overcompensate. Stretching the calf relieves this tension and improves walking mechanics.", 
            "Stand facing a wall with your hands on it. Place one foot back, keeping the heel flat and the leg straight. Gently lean forward until you feel a comfortable stretch in the calf of the back leg.", 
            "Hold the stretch for 30 seconds. Repeat 3 times per leg.", 
            "<ul><li>Relieves posterior chain tension that contributes to knee discomfort.</li><li>Improves ankle mobility, reducing stress on the knee joint.</li><li>Helps restore proper walking gait and function.</li></ul>", 
            "https://youtu.be/mafo7o7OnFo?si=H9MXLAWE3MZvrMdd");
			
// 7. Sciatica
        exercises.addExercise("Piriformis Stretch", "Sciatica", 
            "The Piriformis muscle is located deep in the buttock and can sometimes compress the sciatic nerve, causing sharp pain down the leg. This stretch is the most effective way to relax that muscle and relieve nerve pressure.", 
            "Lie on your back, cross your right ankle over your left knee, and gently pull your legs toward your chest. Hold the stretch for 30 counts/seconds.", 
            "Perform 3 repetitions per leg, holding for 30 counts/seconds", 
            "<ul><li>The most effective stretch for relieving pressure on the sciatic nerve.</li><li>Directly reduces the sharp, radiating pain associated with sciatica.</li><li>Promotes flexibility in the hip and gluteal region.</li></ul>", 
            "https://youtu.be/aSQfNtYRzEc?si=yUGS8aKC4s7-jJoj");
            
        exercises.addExercise("Knee-to-Chest Stretch", "Sciatica", 
            "This gentle, supine stretch targets the muscles of the lower back (lumbar spine) and the glutes on one side at a time. It's often used to warm up the area before moving to deeper stretches like the Piriformis stretch.", 
            "Lie on your back, slowly pull one knee toward your chest, using your hands to deepen the stretch, and hold for 10 counts/seconds.", 
            "Perform 3 repetitions per leg", 
            "<ul><li>Gently eases sciatic nerve pain by stretching the lower back.</li><li>Increases flexibility in the hamstrings and lower gluteal muscles.</li><li>A good, introductory stretch for people experiencing acute lower body pain.</li></ul>", 
            "https://youtu.be/7xy99ZgARVA?si=p9D9iEg4CNLkr2_");

// 8. HAnd Arthritis 
        exercises.addExercise("Finger Bends", "Hand Arthritis", 
            "This range-of-motion exercise is vital for maintaining the functionality of the finger joints that are affected by arthritis. The goal is to maximize joint movement while minimizing stress.", 
            "Bend each finger slowly one by one toward your palm, holding the bend for 2 counts/seconds, then straighten the finger fully.", 
            "Perform 10 repetitions per finger", 
            "<ul><li>Significantly reduces stiffness and painful swelling in the finger joints.</li><li>Supports daily hand functions such as grasping, typing, and gripping.</li><li>Improves the blood flow and overall health of the hand.</li></ul>", 
            "https://youtu.be/GReyxFQVJY0?si=9rpyCP8RtekOrwDN");
            
        exercises.addExercise("Thumb Stretch", "Hand Arthritis", 
            "The thumb is critical for almost all hand movements and is often severely affected by hand arthritis. This stretch focuses specifically on the carpometacarpal (CMC) joint at the base of the thumb.", 
            "Gently pull your thumb across your palm until you feel a gentle stretch at the base of the thumb, holding the position for 5 counts/seconds. ", 
            "Perform 5 repetitions per hand", 
            "<ul><li>Crucially improves thumb movement and dexterity for essential tasks.</li><li>Directly reduces pain associated with thumb arthritis.</li><li>Helps to maintain full hand flexibility and prevent contracture.</li></ul>", 
            "https://youtu.be/wK4II92qHDs?si=MToGReGKstUu5FMy");
            
// 9. Hip Pain
        exercises.addExercise("Hip Flexor Stretch", "Hip Pain", 
            "The hip flexors are often very tight due to prolonged sitting, which can pull on the pelvis and cause hip pain. This standing or kneeling stretch helps to return these muscles to their optimal, relaxed length.", 
            "Kneel on one knee in a lunge position, then gently push your hips forward until you feel a stretch in the front of the back hip, holding for 15 counts/seconds.", 
            "Perform 2 repetitions per leg, holding for 15 counts/seconds", 
            "<ul><li>Significantly reduces chronic hip tightness and strain.</li><li>Improves walking movement and general lower body range of motion.</li><li>Alleviates lower back pain that is often linked to tight hip flexors.</li></ul>", 
            "https://youtu.be/DXuStgWuJV8?si=GsUYWtwYC9KgAvPb");
            
        exercises.addExercise("Side Leg Raises", "Hip Pain", 
            "This exercise isolates and strengthens the abductor muscles (Gluteus Medius/Minimus) on the side of the hip. Strong abductors are vital for stabilizing the pelvis when you walk, preventing hip pain.", 
            "Lie on your side with legs straight. Slowly lift the top leg straight up towards the ceiling, pause briefly at the top, and lower gently.", 
            "Perform 10 controlled repetitions per side.", 
            "<ul><li>Greatly strengthens the outer hip muscles (abductors) for increased stability.</li><li>Effective at reducing pain in the outer hip and IT band region.</li><li>Improves pelvic alignment during standing and walking activities.</li></ul>", 
            "https://youtu.be/pNismoYr1Fg?si=xbL-m6APotQcFuzC");
			
		exercises.addExercise("Knee to Chest Stretch ", "Hip Pain", 
            "A gentle stretch that mobilizes the hip joint and lengthens the muscles on the back of the hip (glutes and piriformis), which can reduce pain radiating down the leg.", 
            "Lie on your back with both knees bent. Gently pull one knee toward your chest using your hands until you feel a comfortable stretch in the back of your hip or buttock.", 
            "Hold the stretch for 30 seconds. Perform 3 repetitions per leg.", 
            "<ul><li>Relieves tension in the gluteal and lower back muscles.</li><li>Aids in improving hip joint mobility and comfort.</li><li>Excellent for relieving non-acute, generalized hip stiffness.</li></ul>", 
            "https://youtu.be/Yd9wY25koVk?si=Wmiincf9pCRgKqOq");
            
		exercises.addExercise("Bridge Exercise", "Hip Pain", 
            "Strengthens the glutes and hamstrings, which are crucial stabilizing muscles for the hip joint. Building strength here often corrects walking mechanics that cause chronic hip pain.", 
            "Lie on your back with your knees bent and feet flat on the floor, hip-width apart. Squeeze your buttocks and lift your hips off the floor until your body forms a straight line from your shoulders to your knees.", 
            "Hold the bridge position for 5 seconds. Perform 10 to 12 repetitions.", 
            "<ul><li>Strengthens the posterior hip chain (glutes and hamstrings) for better hip support.</li><li>Improves hip extension, vital for walking.</li><li>Low-impact strengthening that doesn't compress the hip joint.</li></ul>", 
            "https://youtu.be/v6_GqeEH_F0?si=05dnfmzeCb3oqJx6");
			
		
// 10. Ankle Pain
        exercises.addExercise("Ankle Circles", "Ankle Pain", 
            "Ankle circles are a non-weight-bearing dynamic exercise designed to restore the full range of motion in the ankle joint. This movement is important for lubricating the joint after injury or long periods of rest.", 
            "Sit or lie down with your leg extended. Slowly rotate your foot in a large clockwise circle for 10 complete counts, then reverse the direction and rotate counterclockwise for 10 complete counts.", 
            // Repetition string modified for consistency
            "Perform 10 counts in clockwise and counterclockwise direction.", 
            "<ul><li>Effectively restores ankle mobility and range of motion.</li><li>Gently loosens the ankle joint and increases fluid circulation.</li><li>Essential for warming up the joint before walking or standing for long periods.</li></ul>", 
            "https://youtu.be/mzTQGYGI0Ng?si=GYd7kMI5uaeCfaKp");
            
        exercises.addExercise("Toe Flex and Point", "Ankle Pain", 
            "This simple exercise strengthens the muscles in the lower leg (anterior tibialis and calves) that control foot movement. It is a critical component of rehabilitation after an ankle sprain or injury.", 
            "While sitting, point your toes straight forward as far as possible, then flex them upward toward your shin as far as possible.", 
            "Perform 15 repetitions of this exercise.", 
            "<ul><li>Strengthens the muscles that stabilize the lower leg and foot.</li><li>Assists in the healing and recovery from ankle injuries or stiffness.</li><li>Reduces chronic stiffness and improves fluid movement in the foot.</li></ul>", 
            "https://youtu.be/sWAsdZvqwzk?si=DEM2w07iCnbXZ0Em");
			
		exercises.addExercise("Calf Stretch ", "Ankle Pain", 
            "Tight calf muscles restrict ankle movement and can contribute to ankle pain or Achilles tendon issues. This stretch improves ankle mobility by lengthening the calf.", 
            "Face a wall and place your hands on it. Step the affected foot back, keeping the heel flat and the leg straight. Lean forward until you feel a comfortable stretch in the calf of the back leg.", 
            "Hold the stretch for 30 seconds. Repeat 3 times per leg.", 
            "<ul><li>Relieves tightness in the calf muscles, aiding ankle recovery.</li><li>Increases the range of motion for dorsiflexion (toes up).</li><li>Crucial for reducing tension on the Achilles tendon and heel.</li></ul>", 
            "https://youtu.be/mafo7o7OnFo?si=Pw5F2EZxQGs0dv0t");

// 11. Foot Pain
        exercises.addExercise("Towel Stretch (Plantar Fascia)", "Foot Pain", 
            "This is the primary stretch for the plantar fascia, which is the ligament running along the bottom of the foot and is a common source of heel pain. Stretching this ligament helps to reduce inflammation.", 
            "Sit with your leg extended, loop a towel around the ball of your foot, and gently pull the towel toward your body until you feel a stretch in your arch.", 
            "Perform 3 times per foot. Holding it for 10 counts.", 
            "<ul><li>The main treatment to reduce chronic heel pain caused by Plantar Fasciitis.</li><li>Increases flexibility in the arch and calf muscles.</li><li>Relieves tension that can build up from standing or walking.</li></ul>", 
            "https://youtu.be/rlAjIXb-8BM?si=m5W3gqjXYbauVAUR");
            
        exercises.addExercise("Rolling Massage", "Foot Pain", 
            "This self-massage technique uses a small object like a tennis ball or frozen water bottle to apply targeted pressure to the arch of the foot. It is very effective for breaking up knots and relaxing chronically tight foot tissues.", 
            "Stand or sit and place your arch over a tennis ball or frozen bottle. Slowly roll your foot back and forth over the object, applying firm pressure.", 
            "Perform 1 continuous set of 2–3 minutes per foot", 
            "<ul><li>Provides immediate relief for heel pain and arch soreness.</li><li>Helps to relax tight foot tissues and reduce tension.</li><li>Increases localized blood circulation to speed up tissue recovery.</li></ul>", 
            "https://youtu.be/E_J10u3meDk?si=JFvcusREFm6nCH9k");
			
		exercises.addExercise("Toe Spreading ", "Foot Pain", 
            "This exercise helps strengthen and re-educate the small, intrinsic muscles within the foot. It improves toe dexterity and can help maintain the arch structure.", 
            "Sit on a chair with your feet flat on the floor. While keeping your heel and ball of your foot grounded, try to spread all your toes apart as wide as possible. Hold the spread briefly.", 
            "Perform 10 to 15 repetitions per foot.", 
            "<ul><li>Strengthens the intrinsic muscles of the foot arch.</li><li>Improves balance and toe function during walking.</li><li>Helps decompress toes, beneficial for bunions or neuromas.</li></ul>", 
            "https://youtu.be/LhgaiYrjjRI?si=33UmDxO0ptoaCa5P");

// 12. Asthma 
        exercises.addExercise("Pursed-Lip Breathing", "Asthma / Difficulty Breathing", 
            "This technique controls the rate of exhalation, forcing the airways to stay open longer, which allows trapped air to be released. This helps the lungs work more efficiently and reduces the feeling of shortness of breath.", 
            "Inhale slowly through your nose for a count of 2. Then, exhale slowly through puckered lips (like blowing out a candle) for a count of 4 or longer.", 
            "Perform 10 complete cycles", 
            "<ul><li>Reduces shortness of breath and helps regain breathing control during flare-ups.</li><li>Keeps airways open longer, ensuring more complete oxygen exchange.</li><li>Promotes overall relaxation by slowing down the breathing rate.</li></ul>", 
            "https://youtu.be/7kpJ0QlRss4?si=RK_aOF3h2Bm2GRPn");
            
        exercises.addExercise("Diaphragmatic Breathing", "Asthma / Difficulty Breathing", 
            "Also known as 'belly breathing,' this technique focuses on using the diaphragm, the primary muscle for breathing, instead of shallow chest breathing. Strengthening the diaphragm improves overall lung capacity and oxygen intake.", 
            "Place one hand on your chest and one on your stomach. Breathe slowly and deeply through your nose, making sure only the hand on your stomach rises, then exhale gently.", 
            "Perform 10 full breaths", 
            "<ul><li>Strengthens the diaphragm, the most important breathing muscle.</li><li>Significantly improves lung efficiency and capacity over time.</li><li>Helps to conserve energy by making breathing less strenuous.</li></ul>", 
            "https://youtu.be/Mg2ar-7_HfA?si=Jz9xJsrlx-5Uwni_");
            
// 13. Hypertension
        exercises.addExercise("Slow Marching in Place", "Hypertension", 
            "This is a safe and gentle form of cardiovascular exercise that can be performed without specialized equipment. Regular, low-intensity movement is essential for managing hypertension.", 
            "March slowly and rhythmically in place, lifting your knees to a comfortable height, for 1 continuous set of 1–2 minutes.", 
            "Perform 2 such sets, with a 30-second rest in between", 
            "<ul><li>Helps to gradually lower blood pressure over time through regular activity.</li><li>Improves overall blood circulation and heart health.</li><li>A low-impact way to begin an exercise routine for cardiac health.</li></ul>", 
            "https://youtu.be/Ac8M_Osjy6s?si=m2u6M7sWNzfaN5Ua");
            
        exercises.addExercise("Wall Push-Ups", "Hypertension", 
            "Wall push-ups are an extremely gentle strengthening exercise that avoids the high exertion and strain of traditional push-ups, making them safe for managing hypertension. They work the chest, shoulders, and arms.", 
            "Stand an arm's length from a wall. Lean in and place your hands on the wall, then slowly push your body away and back toward the wall.", 
            "Perform 10 smooth repetitions", 
            "<ul><li>Improves heart health in a safe, extremely low-impact manner.</li><li>Gently strengthens upper body muscles (chest, shoulders, and arms).</li><li>Increases daily physical activity without causing rapid spikes in blood pressure.</li></ul>", 
            "https://youtu.be/oduG4CjpSw0?si=6z3XtiWwPdxLZcM5");
			
		exercises.addExercise("Seated Knee Lifts ", "Hypertension", 
            "A safe, non-standing cardio exercise that helps maintain a gradual heart rate elevation. It is a lower-impact alternative to marching, engaging the core and hip flexors.", 
            "Sit tall in a sturdy chair with your feet flat. Slowly alternate lifting your knees high toward your chest, simulating a marching motion while seated.", 
            "Perform for 1 continuous set of 2 minutes, maintaining a rhythmic pace.", 
            "<ul><li>Maintains a steady cardiovascular workout without the risk of falls.</li><li>Engages the abdominal muscles and hip flexors.</li><li>Promotes circulation and helps manage blood pressure.</li></ul>", 
            "https://youtu.be/GXPCSeFYJPI?si=slYoYoJbQUHYtGGi");
            
// 14. Obesity / Overweight
        exercises.addExercise("Seated Leg Lifts", "Obesity / Overweight", 
            "This is a non-weight-bearing exercise that is perfect for building initial lower body strength while sitting. It helps to activate and strengthen the thigh muscles and knee stabilizers.", 
            "Sit tall in a sturdy chair. Slowly lift one leg straight out in front of you, holding the lift for 2 counts/seconds, then lower gently. ", 
            "Perform 10 complete repetitions per leg.", 
            "<ul><li>Builds essential lower body strength without taxing the joints.</li><li>Significantly improves circulation in the legs and prevents swelling.</li><li>An excellent starting point for improving mobility and function.</li></ul>", 
            "https://youtu.be/uBo1PuTE1ZY?si=xvf7hU2PcacyzSXv");
            
        exercises.addExercise("Step Touch", "Obesity / Overweight", 
            "The step touch is a simple, rhythmic, low-impact cardio movement that elevates the heart rate gently. This type of consistent, easy movement is effective for burning calories and improving endurance.", 
            "Step one foot out to the side, then bring the other foot to 'touch' beside it, repeating the motion for 1 continuous set of 2 minutes. ", 
            "Perform 2 sets with a 1-minute rest in between.", 
            "<ul><li>Provides a light cardio workout that safely burns calories.</li><li>Improves coordination and footwork in a rhythmic way.</li><li>Increases endurance and stamina for daily activities.</li></ul>", 
            "https://youtu.be/uBo1PuTE1ZY?si=xvf7hU2PcacyzSXv");

		exercises.addExercise("Chair Squats", "Obesity / Overweight", 
            "A fundamental functional movement that strengthens the major muscles of the lower body (quads, glutes, hamstrings). It improves the necessary strength and endurance for standing up and walking.", 
            "Start seated on a sturdy chair with feet flat. Lean slightly forward and push through your feet to stand up. Immediately sit back down slowly and under control.", 
            "Perform 8 to 10 slow, controlled repetitions.", 
            "<ul><li>Builds core and lower body strength required for daily tasks.</li><li>A compound movement that helps burn more calories.</li><li>Improves balance and overall functional independence.</li></ul>", 
            "https://youtu.be/GIz1C3yfE1s?si=9H-oxc3yLCPiRcei");
			
		exercises.addExercise("Step Jack", "Obesity / Overweight", 
            "A low-impact alternative to traditional jumping jacks. This rhythmic movement provides cardiovascular benefits and safely elevates the heart rate without the joint jarring impact.", 
            "Stand tall. Step your right foot out to the side while simultaneously raising your arms out to shoulder height. Bring your right foot back to center and lower your arms. Repeat the motion on the left side, alternating between the left and right foot.", 
            "Perform continuously for 1 to 2 minutes.", 
            "<ul><li>Excellent low-impact cardiovascular workout.</li><li>Improves coordination and helps maintain joint safety.</li><li>An effective way to burn calories and improve heart health without jumping.</li></ul>", 
            "https://youtu.be/JHdVMkRBuRA?si=rVEhsfuq97-R3FQb");
			
            
// 16. Frozen Shoulder
        exercises.addExercise("Pendulum Stretch", "Frozen Shoulder", 
            "This highly effective exercise uses gravity to gently move the frozen shoulder joint without the use of muscle contraction. It is an essential first step in regaining range of motion during the recovery phase.", 
            "Lean forward, supporting your weight with your unaffected arm on a table. Let the affected arm hang loosely and swing it in small, gentle circles.", 
            "Perform 10 counts each for clockwise and counter clockwise direction", 
            "<ul><li>Safely and gently reduces chronic stiffness in the shoulder capsule.</li><li>Improves overall range of shoulder movement without pain.</li><li>Aids in the circulation of joint fluid (synovial fluid) for lubrication.</li></ul>", 
            "https://youtu.be/zY5nq68IxwA?si=KxlFIQGiVZPIvd3i");
            
        exercises.addExercise("Towel Stretch", "Frozen Shoulder", 
            "The towel stretch is an assisted stretching technique that helps to regain the ability to reach behind the back, which is severely limited by frozen shoulder. The unaffected arm provides the gentle force needed for the stretch.", 
            "Hold a small towel with both hands behind your back. Use your strong arm to slowly pull the towel upward, gently stretching the affected arm. Hold the stretch for 15 counts/seconds.", 
            "Perform 5 repetitions", 
            "<ul><li>Dramatically improves internal rotation and overall shoulder flexibility.</li><li>Allows for a controlled stretch using the healthy arm for assistance.</li><li>Increases the functional range of motion needed for dressing and hygiene.</li></ul>", 
            "https://youtu.be/fyn_99Du3VY?si=TzD7CXkhMiwtAY1P");
            
        exercises.addExercise("Finger Walk", "Frozen Shoulder", 
            "This is a controlled, active-assisted exercise where the fingers 'walk' up a wall, allowing the shoulder joint to move without the painful muscle contraction of lifting the arm. It allows you to track and increase your height over time.", 
            "Stand facing a wall with your fingertips touching it. Slowly 'walk' your fingers up the wall until you reach a point of gentle resistance, and hold that height for 10 counts/seconds. Perform 10 repetitions.", 
            "Perform 10 repetitions", 
            "<ul><li>Provides a safe, progressive way to increase overhead range of motion.</li><li>Allows the patient to be in control of the stretch intensity at all times.</li><li>Helps in the re-education of shoulder joint movement.</li></ul>", 
            "https://youtube.com/shorts/r7Zv-ZxPZpY?si=afrqHav_Urpsu2BC");
			
// 17. Ankle Sprain 
        exercises.addExercise("Ankle Alphabet", "Ankle Sprain ", 
            "This exercise uses the entire range of motion of the ankle joint in a fluid, non-weight-bearing manner to restore mobility after an injury. It promotes circulation and helps the joint 'remember' its full movement capacity.", 
            "Sit comfortably with your foot suspended. Use your big toe to “draw” every letter of the alphabet (A-Z) in the air using the largest movements possible.", 
            "Perform 1 full A-Z set per ankle", 
            "<ul><li>Fully restores movement and flexibility in the ankle joint.</li><li>Promotes circulation which is essential for rapid healing.</li><li>Works the muscles in all directions without sudden jerking movements.</li></ul>", 
            "https://youtu.be/dpfkCmhtg6I?si=4z_920rGAa3nmtVJ");
            
        exercises.addExercise("Heel Raises", "Ankle Sprain", 
            "This is a critical weight-bearing exercise to strengthen the calf muscles, which are the primary stabilizers of the ankle joint. Strengthening this area helps prevent future sprains and improves walking gait.", 
            "Stand while holding a wall or chair for firm support. Lift both heels slowly off the floor, then lower back down gently. ", 
            "Perform 15 controlled repetitions", 
            "<ul><li>Strengthens the calf/ankle complex for better joint stability.</li><li>Essential for improving dynamic balance and walking.</li><li>Increases the ability of the ankle to tolerate weight-bearing activities.</li></ul>", 
            "https://youtube.com/shorts/4Wn5ugI7VU8?si=Jx_yBMs0NhyxOYbG");
            
        exercises.addExercise("Ankle Resistance Band Flex & Extend", "Ankle Sprain ", 
            "Resistance bands provide a safe way to add external load to the ankle muscles in a controlled, four-directional movement. This is crucial for strengthening the supporting muscles (peroneals, tibialis) and increasing stability.", 
            "Sit with legs extended, loop a resistance band around your foot, and anchor it to something solid. Move your ankle up and down (flexion/extension) and side to side (eversion/inversion).", 
            "Perform 10 counts in each direction", 
            "<ul><li>Strengthens ankle muscles in four key directions for comprehensive stability.</li><li>Improves muscle strength necessary for reacting quickly to uneven ground.</li><li>Aids in the final stage of rehabilitation before returning to sports/running.</li></ul>", 
            "https://youtube.com/shorts/3pmV9xXMQJI?si=TjjSO7iK4SIoo-VC");

// 18. Rounded Upper Back
        exercises.addExercise("Seated Thoracic Stretch", "Rounded Upper Back", 
            "This stretch gently counteracts the hunched-over posture (Kyphosis) common from sitting at a desk. It helps to increase the flexibility of the mid-back (thoracic spine) and opens the chest.", 
            "Sit on a chair, place your hands behind your head, and gently lean your upper back over the backrest, holding the stretch for 5 counts/seconds.", 
            "Perform 10 repetitions, holding for 5 counts/seconds", 
            "<ul><li>Directly reduces the rounding of the upper back (Kyphosis).</li><li>Helps to straighten overall posture by increasing spine flexibility.</li><li>Reduces pain in the mid-back and neck often caused by hunching.</li></ul>", 
            "https://youtu.be/GsPCQ_rQDf0?si=qlD9UdqYh-BT-jcG");
            
        exercises.addExercise("Wall Angels", "Rounded Upper Back", 
            "Wall Angels are a powerful corrective exercise designed to strengthen the small muscles of the upper back (rhomboids) and improve shoulder blade control. It forces you to maintain contact with the wall, which cues proper spinal alignment.", 
            "Stand with your back flat against a wall, bending your elbows to 90 degrees. Slowly slide your arms up the wall and then down, trying to keep your forearms and back of the hands touching the wall.", 
            "Perform 12 smooth repetitions", 
            "<ul><li>Strengthens the upper back muscles crucial for pulling the shoulders back.</li><li>Aids in establishing and maintaining corrective posture.</li><li>Increases mobility in the shoulder joints and upper thoracic spine.</li></ul>", 
            "https://youtu.be/1UU4VvklQ44?si=OtU8nqCTRuHEP3xU");
            
        exercises.addExercise("Chin Tucks", "Rounded Upper Back", 
            "This exercise is crucial for correcting forward head posture, which frequently accompanies a rounded upper back. By pulling the chin back, you reduce strain on the neck and align the head over the spine.", 
            "Sit straight. Gently pull your chin straight back toward your throat without tilting your head up or down, holding the deep tuck for 5 counts/seconds. ", 
            "Perform 15 repetitions, holding for 5 counts/seconds", 
            "<ul><li>Reduces chronic neck strain and associated pain.</li><li>Directly improves head alignment over the neck and shoulders.</li><li>Strengthens the front neck muscles to hold the proper posture for longer periods.</li></ul>", 
            "https://youtu.be/u8C5LgpK3r4?si=6JtqWgTPpFRaLrVE");

// 19. Knee Osteoarthritis 
        exercises.addExercise("Straight Leg Raise", "Knee Osteoarthritis ", 
            "This is a foundational quadriceps strengthening exercise that avoids placing any load on the damaged knee joint. Strong quads are the best defense against the pain of knee osteoarthritis.", 
            "Lie down on your back, bend one knee (for comfort), and keep the affected leg straight. Tighten the thigh muscle and slowly lift the straight leg about 6 inches, holding for 5 counts/seconds.", 
            "Perform 15 repetitions per leg, holding for 5 counts/seconds", 
            "<ul><li>Strengthens knee-supporting muscles (quadriceps) without bending the painful joint.</li><li>Helps reduce pain and swelling by increasing joint stability.</li><li>Improves function for activities like getting up from a chair.</li></ul>", 
            "https://youtube.com/shorts/Nj2z5MIGK9Q?si=gtjo6ohpbvH0Cr02");
            
        exercises.addExercise("Seated Knee Extension ", "Knee Osteoarthritis", 
            "This controlled movement allows you to strengthen the quadriceps muscle throughout the full range of motion of the knee. It's a low-impact way to improve the muscle power needed for walking.", 
            "Sit tall in a chair with feet flat. Slowly extend one leg forward until it is completely straight, then slowly lower it back down to the floor.", 
            "Perform 15 repetitions per leg", 
            "<ul><li>Strengthens the knee joint through its full, non-loaded range of motion.</li><li>Improves knee mobility and prevents the joint from feeling stiff or 'locked'.</li><li>Increases muscle mass in the thigh, which absorbs impact during walking.</li></ul>", 
            "https://youtube.com/shorts/9Du-oWjs_lE?si=H3jBiJJp0miHUxkX");
            
        exercises.addExercise("Mini Squats ", "Knee Osteoarthritis ", 
            "Mini squats are a weight-bearing exercise that teaches the body to move properly while only partially bending the knees to avoid pain. The support from a chair or table is essential for stability.", 
            "Stand while holding a chair or table for support. Slowly bend your knees only slightly (no more than 30 degrees) as if you were about to sit down, then return to standing. ", 
            "Perform 10 slow repetitions", 
            "<ul><li>Gently strengthens the thigh muscles for much better knee support and load absorption.</li><li>Improves functional strength needed for standing and walking.</li><li>Safely introduces weight-bearing movement back into the joint.</li></ul>", 
            "https://youtu.be/0YAFlev6AYg?si=sdAXoIsgA0gHkWM0");

// 20. Scoliosis 
        exercises.addExercise("Cat-Cow Stretch", "Scoliosis", 
            "The Cat-Cow is a neutral exercise that mobilizes the spine in both flexion and extension, which is beneficial for reducing rigidity caused by scoliosis. This movement encourages the entire back to move as a unit.", 
            "Kneel on all fours with your hands shoulder-width apart. Slowly arch your back up (Cat), then drop your stomach and look up (Cow).", 
            "Perform 15 slow, continuous repetitions", 
            "<ul><li>Reduces general stiffness in the spine, especially the lower back.</li><li>Improves flexibility and muscle coordination along the entire back.</li><li>Promotes relaxation in muscles that may be in chronic spasm.</li></ul>", 
            "https://youtube.com/shorts/FyCuSE3mDcc?si=Z2FugzuBWs2AaACO");
            
        exercises.addExercise("Side Plank", "Scoliosis ", 
            "Side planks are a highly effective isometric exercise for strengthening the oblique and hip abductor muscles, which are crucial for stabilizing the spine and correcting muscular imbalance caused by scoliosis. Focus on holding a straight line from head to toe.", 
            "Lie on your side, supporting yourself on your forearm and the edge of your foot. Lift your hips off the floor and hold the straight position for 1 continuous set of 30-60 seconds per side. ", 
            "Perform 1 continuous set of 30-60 seconds per side", 
            "<ul><li>Strengthens deep core muscles (obliques and quadratus lumborum) that directly support the spine.</li><li>Helps to improve posture and reduce functional muscular imbalance.</li><li>Teaches the body to maintain a neutral, straight spinal position.</li></ul>", 
            "https://youtu.be/N_s9em1xTqU?si=GToffXUJJJ3B-FuD");
            
        exercises.addExercise("Back Extension ", " Scoliosis", 
            "This gentle back extension is performed lying face-down, which prevents excessive bending of the spine and allows you to focus on strengthening the back muscles (erector spinae). Stronger back muscles help to hold the spine in a better position.", 
            "Lie face-down, resting your forehead on your hands. Slowly lift your chest and head slightly off the floor without arching your lower back, then lower gently.", 
            "Perform 10 slow repetitions", 
            "<ul><li>Strengthens the lower and middle back muscles that provide spinal support.</li><li>Helps reduce chronic scoliosis-related pain and muscle soreness.</li><li>Improves the endurance of the back muscles needed to maintain proper posture all day.</li></ul>", 
            "https://youtu.be/9ceFn3bH5ls?si=NGO0wazMcHbKvMLU");

// 21. Migraine
        exercises.addExercise("Alternate Nostril Breathing", "Migraine", 
            "This classic yogic breathing technique (Nadi Shodhana) is known to balance the left and right hemispheres of the brain and calm the nervous system. It is highly effective for reducing anxiety and the intensity of a migraine.", 
            "Sit straight. Use your right hand with the index and middle fingers folded to gently alternate closing the right nostril with the thumb and the left nostril with the ring finger, inhaling and exhaling slowly through the open nostril in a balanced rhythm.", 
            "Perform 10 full cycles", 
            "<ul><li>Deeply reduces stress and anxiety, which are common migraine triggers.</li><li>Helps to lower the overall intensity and duration of a migraine attack.</li><li>Calms the nervous system and promotes a balanced state of mind.</li></ul>", 
            "https://youtube.com/shorts/rhtUesVqetc?si=uf2l5nOFLT_Y0vnr");
            
        exercises.addExercise("Neck Stretch", "Migraine", 
            "Tension in the upper neck and shoulders (Trapezius) is a very common trigger for tension headaches and migraines. This side-tilt stretch releases that deep muscular tension.", 
            "Sit straight. Gently tilt your head toward your right shoulder until you feel a comfortable stretch on the left side of your neck, and hold for 15 counts/seconds. ", 
            "Perform 3 repetitions per side, holding for 15 counts/seconds", 
            "<ul><li>Directly reduces tension in the neck muscles that frequently trigger migraines.</li><li>Alleviates chronic tightness and pain radiating from the neck.</li><li>Improves overall cervical mobility and muscle relaxation.</li></ul>", 
            "https://youtube.com/shorts/CroDcDQll4E?si=Y7Bn8puUB0kCkAxV");
            
		exercises.addExercise("Occipital/Trap Stretch", "Migraine", 
            "This targeted stretch hits the suboccipital muscles at the base of the skull and the upper back muscles (trapezius), which are often the main source of tension in migraine sufferers. The deep stretch helps to decompress the area.", 
            "Sit straight. Use the opposite hand (right hand for left stretch) to gently pull your head forward at a 45-degree angle (look down towards your armpit), holding the stretch for 20 counts/seconds. ", 
            "Perform 2 repetitions per side, holding for 20 counts/seconds", 
            "<ul><li>Relieves deep tension in the muscles at the base of the skull, a major headache contributor.</li><li>Decompresses the suboccipital area, which can reduce referred head pain.</li><li>Complements the side-tilt by targeting a different muscle group.</li></ul>", 
            "https://youtube.com/shorts/IKaatHKEucM?si=VOO0u9TFh_xoxmcU");
            
        exercises.addExercise("Corrugator Supercilia Release", "Migraine", 
            "The Corrugator Supercilia muscle is involved in frowning and can hold significant tension that contributes to frontal headaches or ocular (eye) migraines. This is a form of myofascial release to relax that muscle.", 
            "Place two fingers firmly but gently above your eyebrows. Perform small, gentle circular massage motions for a single.", 
            "Perform 1 continuous set of 60 counts/seconds", 
            "<ul><li>Releases muscle tension above the eyebrows often associated with ocular migraine symptoms.</li><li>Helps to alleviate frontal headaches and eye strain.</li><li>A non-pharmacological technique for reducing overall facial tension.</li></ul>", 
            "https://youtu.be/iyRxupAbHto?si=FQGhCpSZL_CcVPHl");
			
// 22. Thigh Pain
        exercises.addExercise("Quadriceps Set", "Thigh Pain", 
            "A basic isometric exercise to strengthen the quadriceps (front of the thigh) without putting stress on the knee joint. This is fundamental for early-stage rehabilitation.", 
            "Sit or lie on your back with the affected leg straight. Push the back of your knee down into the bed or floor, tightening your thigh muscles. Hold the tension.", 
            "Hold the contraction for 5 to 10 seconds. Perform 10 to 15 repetitions.", 
            "<ul><li>Increases strength in the quadriceps muscle.</li><li>Helps reduce swelling and promote circulation around the knee.</li><li>Activates muscle without requiring movement, ideal for acute pain.</li></ul>", 
            "https://youtu.be/IF5eDfb8afM?si=plV0rj8ab50nC4m8");

        exercises.addExercise("Supine Hamstring Stretch", "Thigh Pain", 
            "A gentle, non-aggressive stretch that targets the hamstring muscles (back of the thigh), which often become tight and contribute to pain or lower back issues.", 
            "Lie on your back. Loop a towel or strap around the sole of your foot on the painful leg. Keeping your knee slightly bent, gently pull the leg straight up until you feel a comfortable stretch in the back of your thigh.", 
            "Hold the stretch for 30 seconds. Repeat 3 times on each leg.", 
            "<ul><li>Relieves tension and tightness in the hamstrings.</li><li>Can reduce radiating pain associated with sciatica.</li><li>Improves flexibility, aiding in walking and bending movements.</li></ul>", 
            "https://youtu.be/Il1L75v6gq0?si=ommnIWiw_LxkQIwC");
			
        exercises.addExercise("Straight Leg Raise ", "Thigh Pain", 
            "This exercise strengthens the hip flexors and quadriceps muscles at the front of the thigh, improving dynamic stability without stressing the knee joint.", 
            "Lie on your back with one knee bent and the foot flat on the floor. Keep the painful leg straight. Slowly lift the straight leg about 6-12 inches off the ground, keeping the thigh muscles tight. Lower it slowly.", 
            "Perform 10 to 12 repetitions on the affected leg.", 
            "<ul><li>Builds strength in the hip flexors and quads necessary for walking.</li><li>Low-impact exercise suitable for many knee and hip conditions.</li><li>Improves hip stability and range of motion.</li></ul>", 
            "https://youtu.be/U4L_6JEv9Jg?si=e8_t9kOp5xQYZ14y");

        exercises.addExercise("Side-Lying Hip Abduction", "Thigh Pain", 
            "Targets the hip abductor muscles (gluteus medius) on the outside of the thigh and hip, which are vital for stabilizing the pelvis and preventing strain on the thigh.", 
            "Lie on your unaffected side with your hips and knees straight. Slowly lift your top leg straight up toward the ceiling, keeping your heel slightly behind your hip. Do not rotate your hip or let your pelvis tilt forward.", 
            "Perform 10 to 15 repetitions on the affected leg.", 
            "<ul><li>Strengthens the glutes and outer thigh muscles (abductors).</li><li>Crucial for improving balance and gait mechanics.</li><li>Helps alleviate pain related to IT Band Syndrome and lateral thigh issues.</li></ul>", 
            "https://youtu.be/g9FtnmsIYgI?si=MstHlFZUC8jLJTnS");
    }
}